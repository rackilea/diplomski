List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

//Setup the permission that the user should have in order to run that method.
//It is the customized value based on your security configuration
grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN")); 

//Ensure this user is enabled , active and has above permission
User user = new User("admin", "password", true, true, true, true, grantedAuthorities);

Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
SecurityContextHolder.getContext().setAuthentication(auth);