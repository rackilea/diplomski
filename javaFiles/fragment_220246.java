IDfClient client = new DfClient()
IDfTypedObject config = client.getClientConfig();
config.setString("primary_host", <docbroker adress>);
config.setInt("primary_port", <docbroker port>);

IDfSessionManager manager = client.newSessionManager();
//use manager like usual