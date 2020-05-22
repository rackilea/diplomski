@Override
public Authentication attemptAuthentication(HttpServletRequest req,
                                        HttpServletResponse res) throws AuthenticationException {
try {
    User creds = new ObjectMapper()
            .readValue(req.getInputStream(), User.class);

    return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    creds.getUsername(),
                    creds.getUsername(),
                    new ArrayList<>())
    );
} catch (IOException e) {
    throw new RuntimeException(e);
}