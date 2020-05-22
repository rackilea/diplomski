public AmazonEC2 createAmazonEC2() {
    AmazonEC2 ec2 = new AmazonEC2Client(createAwsCredentials());
    ec2.setEndpoint("https://eu-west-1.ec2.amazonaws.com");
    return ec2;
}

private AWSCredentials createAwsCredentials() {
    AWSCredentials credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    return credentials;
}