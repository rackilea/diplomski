EntityManager em = EMF.get();

NickName n = em.find(NickName.class, nicknameId);

n.givenName = "new name";
n.nickName = "new nickname";
n.timeStamp = new Date();    

em.merge(n);

em.close();