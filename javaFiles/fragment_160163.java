@Controller
@Path("/customer")
public class CustomerController extends BaseController implements Customer {

    @GET
    @Produces({"application/json", "application/xml"})
    public Response searchCustomerDetails(
            @RequestParam("name") String name,
            @RequestParam("id") Integer id) {

            // Returns response with list of links to /customer/{id} (below)

    }


    @GET
    @Produces({"application/json", "application/xml"})
    @Path("/{id}")
    public Response getCustomerDetails(@PathVariable("id") String id) {

            // GET for specific Customer
    }
}