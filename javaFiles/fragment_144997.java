@GET
@Path("/status/test")
@Produces("application/xml")
@Consumes("application/json")
public String testFacade(@HeaderParam("api-version") String version)
{
    if(version.equals("1.0") return test();
    else return test1(); 
}

private String test()
{
    return "Test OK";
}

private String test1()
{
    return "Test OK - 2";
}