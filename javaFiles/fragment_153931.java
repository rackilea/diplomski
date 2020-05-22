private AmazonEC2 provideAmazonEC2() throws Exception {
    AmazonEC2 amazonEC2 = AmazonEC2ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .withRegion(Regions.AP_SOUTHEAST_2)
        .build();

    DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest = new DescribeAvailabilityZonesRequest();
    DescribeAvailabilityZonesResult describeAvailabilityZonesResultFuture = amazonEC2.describeAvailabilityZones(describeAvailabilityZonesRequest);

    try {
        List<AvailabilityZone> describeAvailabilityZonesResult = describeAvailabilityZonesResultFuture.getAvailabilityZones();
        System.out.println(describeAvailabilityZonesResult);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return amazonEC2;
}