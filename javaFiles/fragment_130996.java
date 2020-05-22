Role rl2 = new Role();rl2.setRole("full-access");//Don't save this one because we will manually assign it on login.
Set<Role> rls = new HashSet<Role>();
rls.add(rl2);
CustomUserDetailsService user = new CustomUserDetailsService(appService);
Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities(rls));
SecurityContextHolder.getContext().setAuthentication(authentication);
return "redirect:/securemain";