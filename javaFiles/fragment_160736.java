BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter URL: ");
    String originalURL = br.readLine();

    //get start of URL
    String start = "https://www.google.nl/maps/dir/";

    //get navigation type
    String type = "!3e1";
    Matcher t = getMatcher(originalURL, "!3e\\d");
    if (t.find()) {
        type = t.group();
    }

    //get viewbox parameter
    Matcher v = getMatcher(originalURL, "@[-]?[\\d]+\\.[\\d]+,[-]?[\\d]+.[\\d]+,[-]?[\\d]+[[.]+[\\d]+]*z");
    v.find();
    String viewbox = v.group();

    //get order of points when using VIA
    String data = originalURL.substring(originalURL.indexOf("/data=") + 6);
    ArrayList<String> order = new ArrayList<>();
    Matcher o = getMatcher(data, "!1m[\\d]+");
    while (o.find()) {
        order.add(o.group());
    }
    if (order.size() > 0) {
        //remove the last element which is always m0 as this should not be
        //displayed in the VIA-list
        order.remove(order.size() - 1);
    }

    //!1m2 does not represent the order but indicates that coordinates that are coming up
    order.removeIf(a -> a.equals("!1m2"));

    //get coordinates of via-points
    ArrayList<String> originalViaPoints = new ArrayList<>();
    Matcher c = getMatcher(data, "!1d[-]?[\\d]+.[\\d]+!2d[-]?[\\d]+.[\\d]+");
    while (c.find()) {
        String[] g = c.group().substring(3).split("!2d");
        originalViaPoints.add(g[1] + "," + g[0]);
    }

    //get coordinates of start, end and intermediate points
    originalURL = originalURL.substring(0, v.start());
    ArrayList<String> waypoints = new ArrayList<>();
    Matcher p = getMatcher(originalURL, "[-]?[\\d]+\\.[\\d]+,[-]?[\\d]+.[\\d]+");
    while (p.find()) {
        waypoints.add(p.group());
    }
    //start and end must be displayed seperately
    String bound = waypoints.get(0) + "/" + waypoints.get(waypoints.size() - 1);

    //add intermediate waypoints and via-points to a list of VIA points
    ArrayList<String> viaPoints = new ArrayList<>();

    //we have VIA points to process
    if (!order.isEmpty()) {
        int via_index = 0;
        int wp_index = 1;
        for (String step : order) {
            int iter = Integer.valueOf(step.substring(3)) / 5;
            for (int i = 0; i < iter; i++) {
                viaPoints.add(originalViaPoints.get(via_index++));
            }
            viaPoints.add(waypoints.get(wp_index++));
        }
    } else //There are only waypoints in the URL
    {
        for (int i = 1; i < waypoints.size() - 1; i++) {
            viaPoints.add(waypoints.get(i));
        }
    }

    //calculate prefix according to the amount of nodes of the via points
    int nodes = viaPoints.size();
    String prefix = "!4m" + (5 * nodes + 4) + "!4m" + (5 * nodes + 3) + "!1m" + (5 * nodes);

    //get nodes string
    String viaString = "";
    for (String node : viaPoints) {
        viaString += "!3m4!1m2";
        String[] pieces = node.split(",");
        viaString += "!1d" + pieces[1]; //ALERT: the coordinates are flipped!
        viaString += "!2d" + pieces[0];
        viaString += "!3s0x0:0x0";
    }

    String url = start + bound + "/" + viewbox + "/data=" + prefix + viaString + "!1m0" + type;