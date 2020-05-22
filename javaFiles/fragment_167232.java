public interface RestController {

    @GET("/v2/applications.json")
    ApplicationListDot viewApplications();

}