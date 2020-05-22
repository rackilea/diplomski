try {

    URL url = new URL("http://www.dnb.no/portalfront/datafiles/miscellaneous/csv/kursliste_ws.xml");
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));


    FileOutputStream fout = new FileOutputStream("x.xml");

    String inputLine;
    while ((inputLine = in.readLine()) != null) {
               System.out.println("Line: " + inputLine);
      fout.write(inputLine.getBytes());                        
    }

    fout.close();

    in.close();

} catch(Exception e) {
              e.printStackTrace();
             // writeLog("Error fetching from URL: " + e.getMessage());                                                                           
}