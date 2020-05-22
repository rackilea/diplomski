@Path("/test")
public class TestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() {
        MyResponse response = new MyResponse();
        response.setId("1");
        response.setDepartment("Hard Knocks");
        List<MyEntry> entries = new ArrayList<>();
        MyEntry entry = new MyEntry();
        entry.setKey("key1");
        entry.setValue("value1");
        entries.add(entry);
        entry = new MyEntry();
        entry.setKey("key2");
        entry.setValue("valu2");
        entries.add(entry);
        response.setMyEntry(entries);
        return Response.ok(response).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(MyResponse response) {
        System.out.println("id: " + response.getId());
        System.out.println("Department: " + response.getDepartment());
        System.out.println("MyEntrys: ");
        for (MyEntry entry : response.getMyEntries()) {
            System.out.println(entry);
        }
        return Response.ok().build();
    }
}