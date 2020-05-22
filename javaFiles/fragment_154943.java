public String getBrowser(){

    if (prop.getProperty("browser") == null)    
        return " ";

    return prop.getProperty("browser");

}