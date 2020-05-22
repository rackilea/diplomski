@Produces @Preferred @SessionScoped
public PaymentStrategy getPaymentStrategy(Instance<PaymentStrategy> myInstance) {
  String paymentStrategy = ...;  // Get the name of the payment strategy needed right now

   return myInstance.select(new NamedImpl(paymentStrategy));
}