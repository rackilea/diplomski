@RequestMapping(value = "/session", method = GET)
public AuthenticatedUserDto getCurrentSession(Authentication auth) {
    if (auth == null || !auth.isAuthenticated())
        throw new BadCredentialsException("unkown session");
    return AuthenticatedUserBuilder.build(auth);
}