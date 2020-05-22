.----
|     try 
|     {
|       FileConnection fc = (FileConnection)Connector.open(...);
|      // If no exception is thrown, then the URI is valid
|      if (!fc.exists())
|      {
|          fc.create();  // create the file if it doesn't exist
|      }
|      OutputStream outStream = fc.openOutputStream(); 
|
'-->  for(int i=0;i<v.size();i++){

      outStream.write(((String) v.elementAt(i)).getBytes());

      String br = "\r\n";
      outStream.write (br.getBytes ());
.--> }
|
|      outStream.close();
|      fc.close();
|     }
|     catch (IOException ioe) 
|     {
|        System.out.println(ioe.getMessage() );
|     }
|   }
'--