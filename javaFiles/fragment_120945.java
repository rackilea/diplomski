final TypedQuery<String> query = entityManager
      .createQuery("SELECT u.username FROM Users u WHERE u.username = :username", String.class);
query.setParameter("username", "BillyBob");
if (query.getResultList().size() > 0) {
   // ...
}