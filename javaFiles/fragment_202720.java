@Named
@Path("/")
public class OrderRest {
    private long id = 1;

    @Inject
    private RestTemplate restTemplate;

    @GET
    @Path("order")
    @Produces(MediaType.APPLICATION_JSON)
    public Order submitOrder(@QueryParam("idCustomer") long idCustomer,
            @QueryParam("idProduct") long idProduct,
            @QueryParam("amount") long amount) {

        Customer customer = restTemplate.getForObject("http://localhost:8080/customer/getCustomer?id={id}", Customer.class, idCustomer);
        Product product = restTemplate.getForObject("http://localhost:8080/product/getProduct?id={id}", Product.class,idProduct);

        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setId(id);
        order.setAmount(amount);
        order.setOrderDate(new Date());
        id++;
        return order;
    }
}