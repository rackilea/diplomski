final String jpql = "SELECT u FROM User u WHERE "
  "    u.lastName  like :valueLike" +;
  " OR u.firstName like :valueLike" +;
  " OR u.email     like :valueLike";

result =  entityManager.createQuery(jpql, User.class)
        .setParameter("valueLike", valueLike)
        .getResultList();