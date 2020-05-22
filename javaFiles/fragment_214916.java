@Test
public void test1() throws IOException, InterruptedException {
    Datastore ds = DatastoreOptions.builder().host("http://localhost:9999").projectId("my-project").build().service();
    com.google.cloud.datastore.Key key = ds.newKeyFactory().kind("MyEntity").newKey("mykey");
    com.google.cloud.datastore.Entity entity = com.google.cloud.datastore.Entity.builder(key).set("p1", "Hello World!").build();
    entity = ds.put(entity);
    entity = ds.get(key);
    System.out.println(entity);
}