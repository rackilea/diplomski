@PersistenceContext
EntityManager em;

public void execute(){
  List<Object[]> products = 
      em.createNamedQuery("Product.hasStock").getResultList();

  /* Projections return a List<Object[]> where position 1 in the object array
     corresponds with the first field in the select statement, position two
     corresponds with the second field and so on...  These can also be strongly typed
     if an object is created and the constructor is specified in JPQL statement
  */
}