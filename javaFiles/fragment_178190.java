@Service   
public class CheckoutAsyncInvoker {

    @Autowired
    CheckoutService  checkoutService 

    public void runner()
        for (ProductInfo prod : product) {
            processList=...
            this.checkoutService.checkout(processList);
        }
    }
}