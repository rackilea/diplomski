@GET
@Produces(MediaType.TEXT_PLAIN)
public String sayPlainTextHello() {
    try
    {
         return someRemoteServerApi.getHelloString();
    }
    catch(exception ex)
    {
         return getErrorMessageString();
    }
}