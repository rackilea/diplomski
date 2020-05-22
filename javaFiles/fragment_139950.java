int totalInstances = 100;
int maxInstancesPerNode = 3;
boolean allowLocalRoutees = false;
String useRole = "compute";
ActorRef workerRouter = getContext().actorOf(
   new ClusterRouterPool(new ConsistentHashingPool(0),
      new ClusterRouterPoolSettings(totalInstances, maxInstancesPerNode,
        allowLocalRoutees, useRole)).props(Props
    .create(StatsWorker.class)), "workerRouter3");