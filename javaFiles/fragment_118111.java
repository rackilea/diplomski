final List<String, String> list = new ArrayList<>();
list.add("name1");    
list.add("name2");    
final MultivaluedMap<String, Object> queryParams = new MultivaluedMapImpl<>();
queryParams.addAll("name", list);
final ResteasyClient client = new ResteasyClientBuilder().build();
final ResteasyWebTarget target = client.target(url).queryParams(queryParams);;
final Builder builder = target.request();
builder.accept(MediaType.APPLICATION_JSON)
final Response response = builder.post(Entity.form(form));