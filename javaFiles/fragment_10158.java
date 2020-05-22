@Path("/error")
public class ErrorService {

    private static final Map<Integer, String> statusMsg;
    static
    {
        statusMsg = new HashMap<Integer, String>();
        statusMsg.put(401, "Resource requires authentication");
        statusMsg.put(403, "Access denied");
        statusMsg.put(404, "Resource not found");
        statusMsg.put(500, "Internal server error");
    }

    @GET
    @Path("{httpStatus}")
    public Response error(@PathParam("httpStatus") Integer httpStatus) {

        String msg = statusMsg.get(httpStatus);
        if (msg == null)
            msg = "Unexpected error";

        throw new MyWebApplicationException.Builder()
            .status(httpStatus)
            .addError(msg)
            .build();
    }

}