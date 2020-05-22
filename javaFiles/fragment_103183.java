class A {
    @PersistenceContext       // This is a JPA annotation
    @Produces                 // This is a CDI 'hook'
    private EntityManager em; 
}

class B {
   @Inject                    // Now we can inject an entity manager
   private EntityManager em;
}