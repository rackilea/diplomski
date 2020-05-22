private final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

private Optional<String> findFirstEC2InstanceId() {
  DescribeInstancesRequest request = new DescribeInstancesRequest();

  return ec2.describeInstances(request).getReservations()
            .stream()
            .map(Reservation::getInstances)
            .flatMap(Collection::stream)
            .findFirst()
            .map(Instance::getInstanceId);
}