public static AmazonS3 initS3() throws IOException{
        ClientConfiguration config = new ClientConfiguration();
        config.setUserAgentPrefix("CloudRAID Management");
        config.setUserAgentSuffix("006b8507-b815-47b9-bce0-08b91981f17a");

        InputStream input = AWSS3.class.getClassLoader().getResourceAsStream("awscred.properties");
        Properties prop = new Properties();
        prop.load(input);
        BasicAWSCredentials  credentials  = new BasicAWSCredentials(prop.getProperty("provider.aws01.username"), prop.getProperty("provider.aws01.password"));
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).withCredentials(new AWSStaticCredentialsProvider(credentials)).withClientConfiguration(config).build();

        return s3Client;

}