public static boolean userHasRole(Role role){ // your own Role class/enum
    Authentication userAuthentication = SecurityContextHolder.getContext().getAuthentication();
    List<String> allowedRoles = Arrays.asList(role.name());
    return userAuthentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .anyMatch(allowedRoles::contains);
}