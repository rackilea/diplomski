List<AuthSession> sessions=sessionRepo.findAll();
sessions.forEach(x->{
    em.detach(x);
    AuthUser user=x.getUser();
    if(user!=null) user.setRoles(null);
});