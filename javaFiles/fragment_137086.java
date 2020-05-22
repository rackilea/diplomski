public class ProductDao extends BaseDao<Product> { 
    @PersistenceContext
    private EntityManager em;

    public ProductDao(){
        super(Product.class);
    }

        /**
     * {@inheritDoc}
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}