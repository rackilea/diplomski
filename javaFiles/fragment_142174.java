StandardPBEStringEncryptor encryptor =new StandardPBEStringEncryptor();
encryptor.setPassword("somePass");
encryptor.setAlgorithm("PBEWITHMD5ANDDES");
Configuration configuration = new Configuration().configure();
String pass=encryptor.decrypt(configuration.getProperty("hibernate.connection.password"));
configuration.setProperty("hibernate.connection.password",pass);