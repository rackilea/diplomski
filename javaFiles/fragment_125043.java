abstract class Payment {
    PaymentService paymentService;


    public Payment(OrderPaymentService paymentService) {
        this.paymentService = paymentService;
    }
}