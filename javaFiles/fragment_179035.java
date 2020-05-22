private Optional<Instance> firstEC2Instance() {
  DescribeInstancesRequest request = new DescribeInstancesRequest();

  return ec2.describeInstances(request).getReservations()
            .stream()
            .map(Reservation::getInstances)
            .flatMap(Collection::stream)
            .findFirst();
}