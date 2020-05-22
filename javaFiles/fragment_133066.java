RunJobFlowResult runJobResult = emr.runJobFlow(runJobFlowRequest);
    System.out.printf("Run JobFlowId is: %s\n", runJobResult.getJobFlowId());

    while(true) {
      DescribeClusterRequest desc = new DescribeClusterRequest()
        .withClusterId(runJobResult.getJobFlowId());
      DescribeClusterResult clusterResult = emr.describeCluster(desc);
      Cluster cluster = clusterResult.getCluster();
      String status = cluster.getStatus().getState();
      System.out.printf("Status: %s\n", status);
      if(status.equals(ClusterState.TERMINATED.toString()) || status.equals(ClusterState.TERMINATED_WITH_ERRORS.toString())) {
        break;
      }
      try {
        TimeUnit.SECONDS.sleep(30);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // maybe other handle
    }