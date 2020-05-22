CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
Root<User> root = tupleQuery.from( User.class );

tupleQuery
  .select( cb.tuple( root.get( User_.userLevel ), cb.distinctCount( root ) ) )
  .groupBy( root.get( User_.userLevel ) );

List<Tuple> results = entityManager.createQuery( tupleQuery ).getResultList();