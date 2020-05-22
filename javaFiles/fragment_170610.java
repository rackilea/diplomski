URL oracle = new URL("http://www.oracle.com/");
    URLConnection yc = oracle.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(
                                yc.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) 
        System.out.println(inputLine);
    in.close();