String instanceId = "Your-InstanceId";
AmazonAutoScalingClient amazonAutoScalingClient = new AmazonAutoScalingClient(new BasicAWSCredentials(accessKey, secretKey));
DescribeAutoScalingGroupsResult describeAutoScalingGroupsResult = amazonAutoScalingClient.describeAutoScalingGroups();
for(AutoScalingGroup autoScalingGroup : describeAutoScalingGroupsResult.getAutoScalingGroups()) {
    for(Instance instance : autoScalingGroup.getInstances()) {
        if(instance.getInstanceId().equals(instanceId)) {
            return autoScalingGroup.getAutoScalingGroupName();
        }
    }
}