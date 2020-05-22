@Stateless
@Path("t1")
public class ChickensResource {

    @Inject
    SomeService someService;

    @GET
    @Path("/test")
    public String test() {
        someService.add();
        byte[] b0 = serialize(someService.getState());
        // ...
    }

    public static <T extends Serializable> byte[] serialize(T s) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos))
        {
            oos.writeObject(s);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}