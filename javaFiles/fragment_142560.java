BasicAWSCredentials awsCreds = null;
try {
    awsCreds = new BasicAWSCredentials(settings.getAccessKey(), settings.getSecretKey());
} catch (Exception e) {
    e.printStackTrace();
    throw new IOException(e.getMessage());
}

try {
    AmazonS3 s3Client = AmazonS3Client.builder()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion(Regions.US_EAST_1)
            .build();
} catch (Exception e) {
    e.printStackTrace();
}
System.out.println(s3Client);