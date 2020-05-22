public String getMasterNodeIp(AmazonElasticMapReduceClient emr, String emrId) throws Exception {
    Cluster cluster = emr.describeCluster(new DescribeClusterRequest().withClusterId(emrId));
    ListInstancesResult instances = emr.listInstances(new ListInstancesRequest().withClusterId(emrId));
    String masterDnsName = cluster.getMasterPublicDnsName();
    for (Instance instance : instances.getInstances()) {
        if (instance.getPublicDnsName().equals(masterDnsName)) {
            return instance.getPrivateIpAddress();
        }
    }
    throw new Exception("Failed to find master node private ip.");
}