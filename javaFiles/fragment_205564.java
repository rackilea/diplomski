/**
 * Delete the CloudFormationStack with the given name.
 * 
 * @param stackName
 * @throws Exception
 */
static public void deleteCloudFormationStack(String stackName) throws Exception {
    AmazonCloudFormationClient client = new AmazonCloudFormationClient();
    DeleteStackRequest deleteStackRequest = new DeleteStackRequest().withStackName("");
    client.deleteStack(deleteStackRequest);
}

static public String getCloudFormationStackName() throws Exception {
    AmazonEC2 ec2 = new AmazonEC2Client();
    String instanceId = getInstanceId();
    List<Tag> tags = getEc2Tags(ec2, instanceId);
    for (Tag t : tags) {
        if (t.getKey().equalsIgnoreCase(TAG_KEY_STACK_NAME)) {
            return t.getValue();
        }
    }
    throw new Exception("Couldn't find stack name for instanceId:" + instanceId);
}

static private List<Tag> getEc2Tags(AmazonEC2 ec2, String instanceId) throws Exception {
    DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest().withInstanceIds(instanceId);
    DescribeInstancesResult describeInstances = ec2.describeInstances(describeInstancesRequest);
    List<Reservation> reservations = describeInstances.getReservations();
    if (reservations.isEmpty()) {
        throw new Exception("DescribeInstances didn't returned reservation for instanceId:" + instanceId);
    }
    List<Instance> instances = reservations.get(0).getInstances();
    if (instances.isEmpty()) {
        throw new Exception("DescribeInstances didn't returned instance for instanceId:" + instanceId);
    }
    return instances.get(0).getTags();
}

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
// Example of usage from the code:
deleteCloudFormationStack(getCloudFormationStackName());
// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX