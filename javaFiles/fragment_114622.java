Properties p = new Properties();
try {
    PropertiesConfiguration config = new PropertiesConfiguration("src/test/resources/gui.properties");          
    config.setProperty(key, value);  
    // call save?
    config.save();
} catch (ConfigurationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}