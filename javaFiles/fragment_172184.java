String sQuery = "UPDATE SignIn signIn SET signIn.cookieUUID = :cookieUUID "+
                 "WHERE signIn.user.id = :userID";
     Query query= entityManager.createQuery(sQuery );
     query.setParameter("cookieUUID", null);
     query.setParameter("userID", userID);
     query.executeUpdate();