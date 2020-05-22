User user = new User();
user.setFirstName("john");
user.setLastName("Maclane");

ResteasyClient client = new ResteasyClientBuilder().build();
ResteasyWebTarget target = client.target("URL");
Response response = target.request().post(Entity.entity(user, <MEDIATYPE>));
//Read output in string format
System.out.println(response.getStatus());
response.close();