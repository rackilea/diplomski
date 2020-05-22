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

        Viewable returnViewable =  (Viewable) response.getEntity();
        Map<String, Object> model = (Map<String, Object>) returnViewable.getModel();

        model.put("username", username);
        model.put("isMobile", isMobile);
    }
}