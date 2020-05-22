private void static createSnsClient() {
    Region region = Region.getRegion(Regions.AP_SOUTHEAST_1);
    AWSCredentials credentials = new 
            BasicAWSCredentials(AwsPropertyLoader.getInstance().getAccessKey(),        
                    AwsPropertyLoader.getInstance().getSecretKey());
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setMaxErrorRetry(25);
        clientConfiguration.setRetryPolicy(new RetryPolicy(null, null, 25, true));
        mSnsClient = new AmazonSNSClient(credentials, clientConfiguration);
        mSnsClient.setRegion(region);
}