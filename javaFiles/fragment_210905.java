@Context 
HttpServletResponse response;

@Path("/method")
public void onBinaryMethod() {
    int statusCode = 200;
    //SOME CODE
    response.setStatus(statusCode);
}