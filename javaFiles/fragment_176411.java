User u = new User();            
UserInfo info = new UserInfo();
info.setUser(u);
u.addUserInfo(info);

em.persist(u); // save user