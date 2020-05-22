User user = userDao.findByUsernameAndPassword("username", "password");
SecurityContext ctx = SecurityContextHolder.createEmptyContext();
SecurityContextHolder.setContext(ctx);
UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
authentication.setDetails(user);
ctx.setAuthentication(authentication);