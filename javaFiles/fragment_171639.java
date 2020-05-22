FileInputStream inStream = new FileInputStream(propFile);

    Properties prop = new Properties();
    prop.load(inStream);

    System.out.println(prop.getProperty("entryID"));

    prop.setProperty("entryID", Integer.toString(Integer.parseInt(prop.getProperty("entryID"))+1));
    FileOutputStream outStream  = new FileOutputStream(propFile);
    prop.store(outStream, "");