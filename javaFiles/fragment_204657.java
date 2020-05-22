@POST
@Path("/getHelloWorld")
@Consumes(MediaType.APPLICATION_JSON)
public String helloWorld(@Context HttpServletRequest httpRequest) {
    X509Certificate[] certs = (X509Certificate[]) httpRequest.getAttribute("javax.servlet.request.X509Certificate");
    if (null != certs && certs.length > 0) {
        return <<YOUR CODE HERE>>;
    }
    return <<YOUR CODE HERE>>;
}