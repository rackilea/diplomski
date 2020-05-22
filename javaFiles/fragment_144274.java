@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductsResource {
  private static ImmutableSet<String> orderByChoices = ImmutableSet.of("id", "name", "price", "manufactureDate");

  private final ProductsDao dao;

  public ProductsResource(ProductsDao dao) {
    this.dao = dao;
  }

  @GET
  // Use @InjectParam to bind many query parameters to a POJO(Bean) instead. 
  // https://jersey.java.net/apidocs/1.17/jersey/com/sun/jersey/api/core/InjectParam.html
  // i.e. public List<Product> index(@InjectParam ProductsRequest request)
  // Also use custom Java types for consuming request parameters. This allows to move such validation/sanitization logic outside the 'index' method.
  // https://jersey.java.net/documentation/1.17/jax-rs.html#d4e260 
  public List<Product> index(@DefaultValue("id")  @QueryParam("orderby") String orderBy,
                             @DefaultValue("asc") @QueryParam("order")   String order,
                             @DefaultValue("20")  @QueryParam("perpage") IntParam perpage,
                             @DefaultValue("0")   @QueryParam("page")    IntParam page)

   int limit, offset;

   order = order.toLowerCase(); 
   orderBy = orderBy.toLowerCase();    

   if (!orderByChoices.contains(orderBy)) orderBy = "id"; //sanitize <orderby>
   if (order != "asc" && order != "desc") order = "asc";  //sanitize <order>

   limit = perpage.get();
   offset = page.get() < 0 ? 0 : page.get() * limit;

   return dao.getProducts(orderBy, order, limit, offset);

  }
}