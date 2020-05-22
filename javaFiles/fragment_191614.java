LineNumberReader lnr = new LineNumberReader( new InputStreamReader(new URL( "http://..." ).openStream()) );
  String readLine = lnr.readLine();
  do {
     String[] split = readLine.split(",");
     for( String col : split )
     {
        // Write to DB
        System.out.println(col);
     }
     readLine = lnr.readLine();
  } while (readLine!=null)