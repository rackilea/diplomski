ModelControllerClient client = ModelControllerClient.Factory.create(InetAddress.getByName("localhost"), 9999);  
    ModelNode op = new ModelNode();  
    op.get(ClientConstants.OP).set("read-resource");  

    ModelNode returnVal = client.execute(op);  
    logger.info("release-version: " + returnVal.get("result").get("release-version").asString());  
    logger.info("release-codename: " + returnVal.get("result").get("release-codename").asString());