// Create an interface and add the methods you wish to use with EntityManger.
public interface ProductRepositoryExt {
    public List<Product> findByTitle(String title);
}

// Implement the interface you created. Be careful the class name must be identical to the spring-data @Repository interface with the "Impl" appended.
public class ProductRepositoryImpl implements ProductRepositoryExt {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findByTitle(String title) {
//        em.getTransaction().begin();
        String sql = "SELECT p FROM Product p WHERE p.title=:title')";
        TypedQuery<ProductCategory> query = em.createQuery(sql, Product.class);
        query.setParameter("title", title);
        //  Add the query hints you wish..
        query.setHint(org.eclipse.persistence.config.QueryHints.BATCH_TYPE, "JOIN");
        query.setHint(org.eclipse.persistence.config.QueryHints.BATCH, "p.productCategory");

        return query.getResultList();
//        em.getTransaction().commit();
    }
}

// Extend this interface from your spring-data @Repository interface.
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, ProductCategoryRepositoryExt {
}