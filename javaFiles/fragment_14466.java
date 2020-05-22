import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;


@Path("helloword")
public class SampleControler {

    @GET
    public String doGetAsHtml(@Context HttpServletRequest req, @Context HttpServletResponse response) {
        req.setAttribute("my attr", "my object");
        .....
        return ...;
    }
}