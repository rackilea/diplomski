@MappedSuperclass
public class OtherInheritedDao <T> extends AbstractJpaDao <T>{
    //This is what allows me to inject the entityManager by its annotation
    @PersistenceContext(unitName = "otherPU")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}