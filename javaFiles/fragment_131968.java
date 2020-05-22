public interface AbcService {

    @PATCH
    @Path("/abc/efg")
    public SomeDTO patchSomething(RequestObject request);
}