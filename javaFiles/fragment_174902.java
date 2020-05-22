@Path("/helloworld")
public class HelloWorld {

    @GET
    @Produces("text/plain")
    public String hello(@Context HttpServletRequest req) {

        HttpSession session= req.getSession(true);
        Object foo = session.getAttribute("foo");
        if (foo!=null) {
            System.out.println(foo.toString());
        } else {
            foo = "bar";
            session.setAttribute("foo", "bar");
        }
        return foo.toString();


    }
}