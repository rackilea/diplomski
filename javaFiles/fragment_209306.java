@Provider
@UserInModel
public class UserInModelFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {

        Cookie cookie = request.getCookies().get("User-Data");
        String header =  request.getHeaderString("User-Agent");

        String username = AppUser.getName(cookie.getValue());
        boolean isMobile = AppUser.isMobile(header);

        AbstractView returnViewable =  (AbstractView) response.getEntity();
        returnViewable.setUserName(username);
        returnViewable.setIsMobile(isMobile);
    }
}