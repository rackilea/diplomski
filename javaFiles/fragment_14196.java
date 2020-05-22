@PersistenceContext
private EntityManager entityManager;

..

public Appartmen merge(Appartmen a){
   return entityManager.merge(a);
}