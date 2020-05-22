Map<String, Object> body = new HashMap<>();
body.put("language", "OO");
.....
String json = (new ObjectMapper()).writeValueAsString(body);
Entity<String> entity = javax.ws.rs.client.Entity.json(json);
String result = client.target(fullUrl).request().method("POST", entity, String.class);