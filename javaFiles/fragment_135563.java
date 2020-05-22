final ModelNode address = new ModelNode().setEmptyList();
address.add("subsystem", "datasources");
address.add("data-source", "ExampleDS");

ModelNode request = new ModelNode();
request.get(ClientConstants.OP_ADDR).set(address);
request.get(ClientConstants.OP).set(ClientConstants.WRITE_ATTRIBUTE_OPERATION);
request.get("name").set("connection-url");
request.get("value").set("achooo");
myCliExecutor.executeCliCommandWithResult(request);