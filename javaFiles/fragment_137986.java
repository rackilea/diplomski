ArrayList<Integer> nums = new ArrayList<Integer>();
    String lastLine = "";

    try {
        while ((lastLine = in.readLine()) != null) {

            StringTokenizer st2 = new StringTokenizer(lastLine);
            graph.addEdge(Integer.parseInt(st2.nextToken()), 
                          Integer.parseInt(st2.nextToken()));
        }
    }
    catch (NumberFormatException e) {}

    System.out.println(lastLine);