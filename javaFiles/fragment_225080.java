import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@POST
@Consumes(MediaType.APPLICATION_JSON)
public void acceptsCustomer(Customer c)  {
  // .. do something with the input.
}