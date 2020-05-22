String moreSearch = null;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    try {
        do {
            // ...
            System.out.println("More Flight Query ? Press n/N to exit. Anyother key to continue searching.");
            moreSearch = br.readLine();
        } while (!moreSearch.equalsIgnoreCase("n"));

    } catch (IOException e) {
        Logger.getLogger(FlightSearch.class.getName()).log(Level.SEVERE, "Cant read line from a System.in based BufferedReader", e);
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException ignoreMe) {
                Logger.getLogger(FlightSearch.class.getName()).log(Level.SEVERE, "Can't close a System.in based BufferedReader", ignoreMe);
            }
        }
    }