Properties props = new Properties();    
        FileInputStream fis = null;
        Connection con = null;  
        fis = new FileInputStream("File.properties");
        props.load(fis);

        // load the Driver Class
        Class.forName(props.getProperty("DB_DRIVER_CLASS"));

        // create the connection now
        con = DriverManager.getConnection(props.getProperty("DB_URL"),
                props.getProperty("DB_USERNAME"),
                props.getProperty("DB_PASSWORD"));