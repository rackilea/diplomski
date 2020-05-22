DescribeInstancesRequest request = new DescribeInstancesRequest();

Filter filter1 = new Filter("tag:Environment", Collections.singletonList("Sandbox"));
Filter filter2 = new Filter("tag:Application", Collections.singletonList("xxxxx"));
Filter filter3 = new Filter("tag:Platform", Collections.singletonList("xxxx"));

InstanceProfileCredentialsProvider mInstanceProfileCredentialsProvider =
                new InstanceProfileCredentialsProvider();
AWSCredentials credentials = mInstanceProfileCredentialsProvider.getCredentials();

AmazonEC2 ec2Client = new AmazonEC2Client(credentials);
List<String> privateIps = new ArrayList<>();

ec2Client.describeInstances(request.withFilters(filter1, filter2, filter3)).getReservations().forEach(
                reservation -> reservation
                        .getInstances()
                        .forEach(instance -> privateIps.add(instance.getPrivateIpAddress())));

for (String privateIp : privateIps) {
     hitTheInstance(privateIp);
}