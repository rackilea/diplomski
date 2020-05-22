public boolean hasAuthority(User user, String authority) {
    return roleHierarchy()
        .getReachableGrantedAuthorities(user.getAuthorities())
        .stream()
        .anyMatch(grantedAuthority -> grantedAuthority.getName().equals(authority));
}