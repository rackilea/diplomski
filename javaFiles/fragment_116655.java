WebClient client = WebClient.create("http://MY_SERVER:9090/admission/services/processing");

client.type(MediaType.APPLICATION_JSON_TYPE);

Admission a = new Admission();
a.setCode("73935282");

Response r = client.path("/admission").put(a);