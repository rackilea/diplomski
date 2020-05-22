String yourString = ...
    Properties prop = new Properties();
    try {
        prop.load(new StringReader(yourString));
        String result = prop.getProperty("thisIsNumber1");
        System.out.println(result);
    } catch (IOException e) {
        System.out.println("Error loading properties:");
        e.printStackTrace();
    }