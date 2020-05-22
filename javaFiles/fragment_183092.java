@Path("/Transport")
@Stateless
public class TransportAPI extends AbstractAPIService {
    this.APIDocumentation = "http://docs.transportapi.com/index.html?raml=http://transportapi.com/v3/raml/transportapi.raml";

    //Desired Functionality:

    //Access your superclass variable
    String value = this.APIDocumentation; //or super.APIDocumentation

    ...
}