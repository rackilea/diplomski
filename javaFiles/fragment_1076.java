final UserDetails jimmyDetails = myDetailsService.loadUserByUsername("Jimmy");
final Collection<GrantedAuthority> jimmyAuthorities = jimmyDetails.getAuthorities();

// make it a Collection<String> by iterating and calling .getAuthority()

plainAuthorities.contains("ROLE_YOU_NEED_TO_CHECK_FOR");