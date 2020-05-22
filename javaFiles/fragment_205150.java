DescribeAutoScalingGroupsRequest asgRequest = new DescribeAutoScalingGroupsRequest()
        .withAutoScalingGroupNames("AUTO_SCALING_GROUP_NAME");
DescribeAutoScalingGroupsResult asgResult = asgClient.describeAutoScalingGroups(asgRequest);

List<AutoScalingGroup> groupList = asgResult.getAutoScalingGroups();

groupList.forEach((asgroup) -> System.out.println(asgroup.getDesiredCapacity())); // Desired Capacity
groupList.forEach((asgroup) -> System.out.println(asgroup.getMinSize())); // Min
groupList.forEach((asgroup) -> System.out.println(asgroup.getMaxSize())); // Max