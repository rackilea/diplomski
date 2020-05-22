Client client = Client.create();
WebResource webResource = client.resource("http://site.com/resource");
MultivaluedMap<String, String> map = new MultivaluedMapImpl();
map.put("loginId", loginId);
...
ClientResponse response = webResource.type("application/x-www-form-urlencoded")
             .post(ClientResponse.class, map);