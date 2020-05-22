//import things

@Path("/userrealam")
public class UserService {
    @Context HttpServletRequest request;
    @Context HttpServletResponse response;


        @GET
        @Path("logout")
        @Produces({MediaType.TEXT_PLAIN})
        public void logout() throws JAXBException, IOException {
            try {
                        if (request.getUserPrincipal() != null){
                        request.logout();
                      }
                      }
             catch (Exception e) {
                    }

          }
}