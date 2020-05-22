try {
  Configurations.getInstance().getProperty("DynamoDBProfileCredentials");
  credentials = new ProfileCredentialsProvider( Configurations.getInstance().getProperty("DynamoDBProfileCredentials")).getCredentials(); 
} catch (Exception e) {
  log.error("Cannot load the credentials from the credential profiles file. " +
      "Please make sure that your credentials file is at the correct " +
      "location (C:\\Users\\your username\\credentials), and is in valid format.",e);
  throw new AmazonClientException(e);
}