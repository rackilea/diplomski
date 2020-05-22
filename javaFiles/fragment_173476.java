@Produces(MediaType.APPLICATION_JSON)
public MyObject getValues(@Context HttpServletResponse response) {
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    ...
}