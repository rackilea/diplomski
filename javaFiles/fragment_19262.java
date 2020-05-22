// Crude example
public class PaymentEndpoint {

  @Consumes("application/x-www-form-urlencoded")
  public Payment handleCcPayment(@FormParam("name") String name) {
    CCInfo ccInfo = new CCInfo(name);
    return this.paymentService.processPayment(ccInfo);
  }

  @Consumes("application/json")
  public Payment handleTicketPayment(Ticket ticket) {
    return this.paymentService.processTicket(ticket);
  }

}