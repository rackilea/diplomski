String urlstr = "https://ejbca05.prv:8443/ejbca/ejbcaws/ejbcaws?wsdl";
        System.setProperty("javax.net.ssl.trustStore","C:/Users/l./Downloads/truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","provae");
        System.setProperty("javax.net.ssl.keyStore","C:/Users/l./Downloads/superadmin.p12");
        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
        System.setProperty("javax.net.ssl.keyStorePassword","provae");