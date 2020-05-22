//let's say that when you GET to /users?id=2 the server should return the user with id 2
//first start the server on your favourite port
MockHttpServer server = new MockHttpServer(portNum);
server.start();

//We will add a mock response for every request we will do, so in this case, just one mock response
server.enqueueResponse(Status.OK, "application/json,"{\"user_id\":15,\"name\":\"paul\"}");

//now we will use curl or whatever to make the GET
curl http://0.0.0.0:3000/users?id=2

// we get the request object
Request req = server.getRequest();
assertEquals(req.getMethod(),"GET");
assertEquals(req.getParams().get("id"),"2")