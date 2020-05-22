if("OMS".equalsIgnoreCase(mgmtSystem)) {
        /*
         * Loading the properties file based on environment qa/qa2/prod
         */
        if("qa".equalsIgnoreCase(env)) {

            propFile = EnvHandler.class.getResourceAsStream("/com/services/agentsMonitor/OMS/Credentials_qa.properties");   //I have error here
            System.out.println("PropFile->" + propFile.toString());
            prop.load(propFile);
            return prop;

        }
        else if("qa2".equalsIgnoreCase(env)) {

            propFile = EnvHandler.class.getResourceAsStream("/com/services/agentsMonitor/OMS/Credentials_qa2.properties");
            prop.load(propFile);
            return prop;

        }else if("prod".equalsIgnoreCase(env)) {

            propFile = EnvHandler.class.getResourceAsStream("/com/services/agentsMonitor/OMS/Credentials_prod.properties");
            prop.load(propFile);
            return prop;

        }
    } else if("IMS".equalsIgnoreCase(mgmtSystem)) {
        /*
         * Loading the properties file based on environment qa/qa2/prod
         */
        if("qa".equalsIgnoreCase(env)) {

            propFile = EnvHandler.class.getResourceAsStream("/com/services/agentsMonitor/IMS/Credentials_qa.properties");     
            prop.load(propFile);
            return prop;

        }
        else if("qa2".equalsIgnoreCase(env)) {

            propFile = EnvHandler.class.getResourceAsStream("/com/services/agentsMonitor/IMS/Credentials_qa2.properties");
            prop.load(propFile);
            return prop;

        }else if("prod".equalsIgnoreCase(env)) {

            propFile = EnvHandler.class.getResourceAsStream("/com/services/agentsMonitor/IMS/Credentials_prod.properties");
            prop.load(propFile);
            return prop;

        }
    }