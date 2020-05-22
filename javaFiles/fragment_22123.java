@Client(id="",//The ID of the client
        value = "url", //The URL or service ID of the remote service
        path = "/user",//The base URI for the client. Only to be used in conjunction with id().
        errorType=Object.class,//The type used to decode errors
        configuration=<? extends HttpClientConfiguration>//The http client configuration bean to use
        )
@Header(name="", value="")      
public interface TestClient {
    @Get("?id=123")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Single<HttpResponse<User>> getUser();
   }