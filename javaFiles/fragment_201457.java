Properties prop = new Properties();

    try {
        //load a properties file
        prop.load(new FileInputStream("it-IT.properties"));

        //get the property value and print it out
        System.out.println(prop.getProperty("file"));  //prints "File"
        System.out.println(prop.getProperty("edit"));//prints "Modifica"

    } catch (IOException ex) {
        ex.printStackTrace();
    }