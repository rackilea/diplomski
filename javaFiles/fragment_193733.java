public List<Items> getItemsByPage(int page, int pageSize) {
  return session.createQuery( "..." )
    .setFirstResult( ( page - 1 ) * pageSize )
    .setMaxResults( pageSize )
    .getResultList();
}