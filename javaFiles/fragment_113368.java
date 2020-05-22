@GET
@Path("/benchmark")
@Produces("text/html")
public MyModel getForbiddenBrowserList() {
    MyModel model = generateMyModel();
    //And now I want to do something like:
    return MyModel;
}