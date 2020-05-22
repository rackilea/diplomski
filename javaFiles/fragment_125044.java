@Component
public class CreatePayment extends Payment{
    private OtherService1 otherSerivce1;

    @Autowired
    public CreatePayment(PaymentService paymentService) {
        super(paymentService);
    }
}