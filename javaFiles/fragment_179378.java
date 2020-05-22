AmazonS3Client s3Client = AmazonS3ClientBuilder.standard().withRegion(REGION).
.withClientConfiguration(getClientConfiguration()).build();

private ClientConfiguration getClientConfiguration() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setRetryPolicy(new RetryPolicy(null, null, MAX_TRIES, false);
        return clientConfiguration;
}