DescribeInstancesRequest request = new DescribeInstancesRequest();
List<String> valuesT1 = new ArrayList<String>();
valuesT1.add("my-keypair-name");
Filter filter = new Filter("key-name", valuesT1);

DescribeInstancesResult result = ec2.describeInstances(request.withFilters(filter));

List<Reservation> reservations = result.getReservations();

for (Reservation reservation : reservations) {
    List<Instance> instances = reservation.getInstances();

    for (Instance instance : instances) {

        System.out.println(instance.getInstanceId());


    }
}