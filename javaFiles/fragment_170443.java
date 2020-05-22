public void createNode(NodePath nodePath, NodeData nodeData, NodeRights nodeRights, NodeCreationHandler nodeCreationHandler) throws KeeperException, InterruptedException, ZookeeperCreationException {

        if (zk == null) {
            throw new ZookeeperCreationException("The zookeeper client has not been instanced.");
        }       
        String targetPath = nodePath.getFullNodePath();
        logger.warn("full path: " + targetPath);
        targetPath = targetPath.substring(1, targetPath.length());
        logger.warn("full path mod: " + targetPath);
        byte[] serializedData = nodeData.serialize(new Object());
        String[] array = targetPath.split(ICoordinationConstants.BASE_ROOT_SPTR);
        String acum="";
        for (int i = 0; i < array.length-1; i++) {
            acum+=(ICoordinationConstants.BASE_ROOT_SPTR+array[i]);
            logger.warn("acum: " + acum);
            if (zk.exists(acum, null) == null) {
                logger.warn("It does not exists, proceed to create it...");
                zk.create(acum, serializedData, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        }
        zk.create(acum+ICoordinationConstants.BASE_ROOT_SPTR+array[array.length-1], serializedData, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);             
    }