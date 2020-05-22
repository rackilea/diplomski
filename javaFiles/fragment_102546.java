String pathKeyStore = package.Test.class.getResource("file.jks").getPath();
pathKeyStore = pathResourceKeyStore.replaceAll("%20", " ");

System.setProperty("javax.net.ssl.trustStore", pathKeyStore);
System.setProperty("javax.net.ssl.trustStorePassword", "password");
System.setProperty("javax.net.ssl.keyStore", pathKeyStore); 
System.setProperty("javax.net.ssl.keyStorePassword", "password");