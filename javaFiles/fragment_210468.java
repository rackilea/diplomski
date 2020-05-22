FileInputStream fstream = new FileInputStream("c:/temp/a.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String line;

    //Read File Line By Line
    while ((line = br.readLine()) != null)   {
      // Print the content on the console
      System.out.println (line);
      String [] lines = line.split ("\t");
      if (lines.length < 2) {
            System.err.println ("error with line " + line);
            continue;
         }        

    }

    //Close the input stream
    br.close();