//open a buffered reader on process std output
    InputStreamReader ir = new InputStreamReader(theProcess1.getInputStream());
    BufferedReader in = new BufferedReader(ir);

   //read it line per line
    String line;
    while ((line = in.readLine()) != null) {

       System.out.println(line);

    }