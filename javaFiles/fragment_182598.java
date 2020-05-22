System.out.println("Stub mapping size: " + wireMockServer.getStubMappings().size());

Stub mapping size: 1
{
  "id" : "da5735a6-b6cc-45aa-8256-fb88b5670610",
  "request" : {
    "url" : "/some/thing",
    "method" : "GET"
  },
  "response" : {
    "status" : 200,
    "body" : "Hello world!",
    "headers" : {
      "Content-Type" : "text/plain"
    }
  },
  "uuid" : "da5735a6-b6cc-45aa-8256-fb88b5670610"
}