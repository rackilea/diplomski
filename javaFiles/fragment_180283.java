Properties p1 = new Properties();
        InputStream is1 = new FileInputStream("File.txt");
        p1.load(is1);
        PrintWriter pw1 = new PrintWriter(System.out);
        System.out.println("printing property values");
        p1.list(pw1);
        Enumeration<?> e = p1.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = p1.getProperty(key);
            System.out.println("Key : " + key + ", Value : " + value);
        }

This will get you all the keys and respective values together on the console.