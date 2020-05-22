@SuppressWarnings({ "rawtypes", "unchecked" })
private User logAdminAsUser(User admin, String roleName) {
    SecurityContextHolder.getContext().setAuthentication(
        new TestingAuthenticationToken(admin, null, "ROLE_ADMIN"));
    Authentication adminAuth = SecurityContextHolder.getContext().getAuthentication();
    SwitchUserGrantedAuthority switchUserGrantedAuthority =
        new SwitchUserGrantedAuthority("ROLE_ADMIN", adminAuth);
    List authorities = new LinkedList();
    authorities.add(switchUserGrantedAuthority);
    User user = populator.storeUser("ROLE_USER");
    SecurityContextHolder.getContext().setAuthentication(
        new TestingAuthenticationToken(user, null, authorities));
    return user;
}