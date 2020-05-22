Properties properties = new Properties();
properties.loadFromXML(inputStream);

String key = "TL";
String defaultValue = "";
String value = properties.getProperty(key, defaultValue);