[...]
    if (propKey == null) {
    // Key is not present so enter the key into the properties file
    mainFile.setProperty(confirmKey, "testtest");


    [...]
    Reader reader = null;
    try
    {
    reader = new FileReader( "mainAppProp.properties" );
    Properties prop2 = new Properties();
    prop2.load( reader );
    prop2.list( System.out );
    }
    catch ( IOException e )
    {
    e.printStackTrace();
    }
    finally
    {
    if (reader != null) {
    reader.close(); 
    }
    }
    }
    [...]
   }