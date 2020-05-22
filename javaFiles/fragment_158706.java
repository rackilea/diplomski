public String decryptVar(String var,String PathPropertyFile) throws Exception{

    try {
         BasicTextEncryptor encryptor = new BasicTextEncryptor();
         Properties props = new EncryptableProperties(encryptor);
         InputStream fis = this.getClass().getResourceAsStream(PathPropertyFile);
         props.load(fis);
         encryptor.setPassword(props.getProperty("PROPERTY_IN_FILE")); 
         return props.getProperty(var);

    } catch (Exception e) {
    throw new Exception(e.getMessage());
    }   

}