XStream xstream = new XStream();
        xstream.alias("root", com.config.ServiceNServiceConfigurations.class);
        xstream.alias("service",com.config.Service.class);
        xstream.alias("serviceConfiguration",com.config.ServiceConfiguration.class);
        xstream.aliasField("Key", com.config.ServiceConfiguration.class, "key");
        xstream.aliasField("Value", com.config.ServiceConfiguration.class, "value");