String path = ...;  //--- Path to folder with *.properties files

if (locale.equals("en")) path += "I18n_en.properties";
else path += "I18n_es.properties";

FileInputStream fis = new FileInputStream(path);
ResourceBundle resourceBundle;
try {
    resourceBundle = new PropertyResourceBundle(fis);
} finally {
    fis.close();
}