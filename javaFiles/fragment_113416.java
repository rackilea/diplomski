if ( b.getAId() != null ) {
  A a = entityManager.find( A.class, b.getAId() );
  a.getBs().add( b );
  a = entityManager.merge( a );

  b.setA( a );
  entityManager.persist( b );
}