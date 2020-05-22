@RestController
public class ShopController {

    final Shop2CustomerConnectorRequester shop2CustomerConnectorRequester;
    final Shop2CartConnectorRequester shop2CartConnectorRequester;

    @Autowired
    public ShopController(Shop2CustomerConnectorRequester shop2CustomerConnectorRequester,
            Shop2CartConnectorRequester shop2CartConnectorRequester) {
        this.shop2CustomerConnectorRequester = shop2CustomerConnectorRequester;
        this.shop2CartConnectorRequester = shop2CartConnectorRequester;

    }

   @GetMapping("/listAll")
   public List getAllLists() {
       List<Customer> customerList = hop2CustomerConnectorRequester.getCustomer();
       List<Cart> cartList = hop2CartConnectorRequester.getCart();

       List<?> list =  Stream.concat(customerList.stream(), cartList.stream()).collect(Collectors.toList());

       return list;
   }