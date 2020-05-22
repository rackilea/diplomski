@Stateless
@Local(IDAOEnitityFactory.class)
public class DAOEnitityFactory implements IDAOEnitityFactory {
@PersistenceContext(unitName = "MY_PU")
protected EntityManager entityManager;
@Override
public List<T> findAllByClass(Class c) {     
return this.getAuditReader().createQuery()
        .forRevisionsOfEntity(c, true, false)
        .setMaxResults(10).getResultList();
 }