@UseStringTemplate3StatementLocator
public interface ProductsDao {

    @RegisterMapperFactory(BeanMapperFactory.class) // will map the result of the query to a list of Product POJOs(Beans)
    @SqlQuery("select * from products order by <orderby> <order> limit :limit offset :offset")
    List<Product> getProducts(@Define("orderby") String orderBy, @Define("order") String order,
                                     @Bind("limit") int limit, @Bind("offset") int offset);

    @SqlQuery("select count(*) from products")
    int getProductsCount();

}