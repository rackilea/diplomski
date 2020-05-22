@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {
    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        try {
            // Extract the token from the HTTP Authorization header
            String token = authorizationHeader.substring("Bearer".length()).trim();
            // Validate the token
            Claims claims =  Jwts.parser().setSigningKey("MYSECRET".getBytes("UTF-8")).parseClaimsJws(token).getBody();

            Method method =resourceInfo.getResourceMethod();
            if( method != null){
                // Get allowed permission on method
                JWTTokenNeeded JWTContext = method.getAnnotation(JWTTokenNeeded.class);
                Role permission =  JWTContext.Permissions();

                if(permission != Role.NoRights ) {
                    // Get Role from jwt
                    String roles = claims.get("Role", String.class);
                    Role roleUser = Role.valueOf(roles);

                    // if role allowed != role jwt -> UNAUTHORIZED
                    if (!permission.equals(roleUser)) {
                        throw new Exception("no roles");
                    }

                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}