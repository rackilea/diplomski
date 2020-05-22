@GET
@Path(value = "/getProduct/{Id}/{dbUrl}/{dbUname}/{dbPass}")
@Produces(MediaType.APPLICATION_JSON)
public Product getProductById(@PathParam(value = "Id") int id,
    @PathParam(value = "dbUrl") String dbUrl,
    @PathParam(value = "dbUname") String dbUname,
    @PathParam(value = "dbPass") String dbPass) {
  DataSource ds = JdbcConnectionPool.create(dbUrl, dbUname, dbPass);
  DBI dbi = new DBI(ds);
  ProductDAO dao = dbi.open(ProductDao.class);
  Product product = dao.findById(id);
  dao.close();
  ds.dispose();
  return product;
}

@RegisterMapper(ProductMapper.class)
static interface ProductDao {
  @SqlQuery("select id from product_table where id = :id") // Whatever SQL query you need to product the product
  Product findById(@Bind("id") int id);

  @SqlQuery("select * from product_table")
  Iterator<Product> findAllProducts();
}

static class ProductMapper implements ResultSetMapper<Product> {
  public Product map(int index, ResultSet r, StatementContext ctx) throws SQLException {
    return new Product(r.getInt("id")); // Whatever product constructor you need
  }
}