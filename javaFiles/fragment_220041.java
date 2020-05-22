/*
* First, create (or ask some other component for) the adequate encryptor for   
* decrypting the values in our .properties file.   
*/  
StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();     
encryptor.setPassword("jasypt"); // could be got from web, env variable...    
/*   
* Create our EncryptableProperties object and load it the usual way.   
*/  
Properties props = new EncryptableProperties(encryptor);  
props.load(new FileInputStream("/path/to/my/configuration.properties"));

/*   
* To get a non-encrypted value, we just get it with getProperty...   
*/  
String datasourceUsername = props.getProperty("datasource.username");

/*   
* ...and to get an encrypted value, we do exactly the same. Decryption will   
* be transparently performed behind the scenes.   
*/ 
String datasourcePassword = props.getProperty("datasource.password");

 // From now on, datasourcePassword equals "reports_passwd"...