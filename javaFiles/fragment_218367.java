@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the token header from the HTTP Authorization request header
        String token = 
            requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Check if the token is present
        if (token == null || token.isEmpty()) {
            throw new NotAuthorizedException("Token must be provided");
        }

        // Validate the token
        validateToken(token);
    }

    private void validateToken(String token) {

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
            .Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Arrays.asList(CLIENT_ID))
                .build();

        GoogleIdToken idToken = verifier.verify(token);
        if (idToken != null) {
            Payload payload = idToken.getPayload();
            System.out.println("User ID: " + payload.getSubject());
        } else {
            throw new NotAuthorizedException("Invalid token.");
        }
    }
}