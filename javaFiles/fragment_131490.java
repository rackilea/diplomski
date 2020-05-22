/* This is executed once, after user successful login. */

Set<String> roles = new HashSet<String>();
for (GrantedAuthority authority : authentication.getAuthorities()) {
   roles.add(authority.getAuthority());
}

session.setAttribute("userRoles", roles);