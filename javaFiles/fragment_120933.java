try {
    File file = new File("externalPreferences.xml");
    FileInputStream fileInput = new FileInputStream(file);
    Properties properties = new Properties();
    properties.loadFromXML(fileInput);
    fileInput.close();

    Enumeration enuKeys = properties.keys();
    SharedPreferences.Editor editor = preferences.edit();
    while (enuKeys.hasMoreElements()) {
        String key = (String) enuKeys.nextElement();
        String value = properties.getProperty(key);
        editor.putString(key, value);
        editor.commit();
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}