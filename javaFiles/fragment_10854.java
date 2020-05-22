@Path("/giftlists")
public class GiftLists{

    @Resource
    private SessionContext sessionContext;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed(USER) // Allow only authenticated users to access this
    @Path("/{giftListId}")
    public void getGiftListById(@NotNull @PathParam("giftListId") Long giftListId) {

        User user = userDAO.findUserByLogin(sessionContext.getCallerPrincipal().getName());

        GiftList giftList = giftListDAO.findGiftListByIdAndUser(giftListId, user); // user is provided to your DAO method / query, so giftList is returned only when User owns it. (No FORBIDDEN error)

        if(giftList == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

    }
}