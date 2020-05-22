String path="";                             
        File propFile = new File(fileName);
    Properties properties = new Properties();
    properties.load(new InputStreamReader(new FileInputStream(propFile),"UTF-8"));
        path = properties.getProperty(propertyValue);          
        return path;    
    }//