// enable pretty printing
Gson gson = new GsonBuilder().setPrettyPrinting().create();

// too lazy to fill the objects by hand
String reqJson = "{\"AppId\":\"2\",\"ThirdParty\":\"3\",\"UserId\":\"1\",\"UserToken\":\"4\"}";
String req1Json = "{\"AppId\":\"-33\",\"ThirdParty\":\"3\",\"UserId\":\"1\",\"UserToken\":\"4\"}";

// deserialize it with gson
RequestDataDTO req = gson.fromJson(reqJson, RequestDataDTO.class);
RequestDataDTO req1 = gson.fromJson(req1Json, RequestDataDTO.class);

// initiliaze the container
RequestDataDTOContainer container = new RequestDataDTOContainer();

// adding the 2 req objects with the certain key
container.putRequestDataDTO("req", req);
container.putRequestDataDTO("req1", req1);

// Print it as pretty json
System.out.println(gson.toJson(container));