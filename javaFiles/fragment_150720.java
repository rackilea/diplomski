InputStream in = new FileInputStream(new File("C:/temp/test.txt"));
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder out = new StringBuilder();
    try {
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
         }
         System.out.println(out.toString());   //Prints the string content read from input stream
    }
    catch(Exception ex) {//TODO}
    finally {
         reader.close();
    }