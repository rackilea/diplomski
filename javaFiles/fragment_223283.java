// this is just your json string.
String yourJson = "{\"result\":\"_error\",\"invokeId\":2,\"data\":{\"timestamp\":1.401824129758E12,\"rootCause\":{\"message\":\"Wrong client version for server\",\"localizedMessage\":\"Wrong client version for server\",\"rootCauseClassname\":\"login.impl.ClientVersionMismatchException\",\"substitutionArguments\":[\"4.9\",\"4.8.14_05_16_17_02\"],\"errorCode\":\"LOGIN-0001\"},\"headers\":{},\"correlationId\":\"00E36368-6158-CD63-56CA-4F39493E8ED3\",\"faultCode\":\"Server.Processing\",\"messageId\":\"D8424EAD-8D0B-5441-820B-775B99812CFD\",\"faultString\":\"login.impl.ClientVersionMismatchException : Wrong client version for server\",\"timeToLive\":0.0,\"clientId\":\"D8424E8B-5F0F-1ECD-C29F-C6440488B0FC\",\"destination\":\"loginService\"},\"version\":0}";
// create a parser
JsonParser parser = new JsonParser();
// parse then get your root node as a JsonObject
JsonObject obj = parser.parse(yourJson).getAsJsonObject();

// traverse your object
JsonArray subArgs = obj.get("data").getAsJsonObject()
        .get("rootCause").getAsJsonObject()
        .get("substitutionArguments").getAsJsonArray();

// because the get(1) returns a JsonElement you will need to use getAsString 
// to retrive the actual results
System.out.println(subArgs.get(1).getAsString()); // 4.8.14_05_16_17_02