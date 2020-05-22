String inputPropties = "KEY1||VALUE1\nKEY2||VALUE2\nKEY3||VALUE3";
    inputPropties = inputPropties.replaceAll("\\|\\|","=");
    Properties properties = new Properties();
    properties.load(new StringReader(inputPropties));
    for( String key: properties.stringPropertyNames()) {
        System.out.println(key+" = "+properties.getProperty(key));
    }