private void processCreditCardPayment(List<Payment> payments) throws ProcessPaymentException{
PaymentGatewayConfig paymentGateway = new PaymentGatewayConfig();
String crypt_type = "7";
List<Payment> failedPayments = new ArrayList<Payments>();
for (Payment payment : payments) { 
    try {
        chargeMemberCreditCard(payment, crypt_type, paymentGateway);
    } catch (ProcessPaymentException ppe) {
        filedPayments.add(payment);
        // or you can accumulate excetions instead of Payments
    }
}
// create some higher level exception with failed Payent collection and throw it, or log it.