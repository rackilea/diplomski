@RepositoryRestController
public class PaymentController {

    @PostMapping("/payments")
    @ResponseBody
    public Payment create() {
        // some code...
    }

}