@MappedSuperclass
public class InheritedDao <T> extends AbstractJpaDao <T>{
    //This is what allows me to inject the entityManager by its annotation
    @PersistenceContext(unitName = "myPU")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}