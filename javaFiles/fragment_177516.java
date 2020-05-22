CoreDescriptor coreDescriptor = rb.req.getCore().getCoreDescriptor();

String collectionName = coreDescriptor.getCloudDescriptor().getCollectionName();

ZkController zkController = coreDescriptor.getCoreContainer().getZkController();

String zookeeperUrl = zkController.getZkServerAddress();