// Crude example
public class PaymentEndpoint {

  public Response handlePayment(HttpRequest request) {
    if (request.getContentType() == "application/json") {
      Ticket ticket = deserializeTicket(request);
      Payment payment = this.paymentService.processTicket(ticket);
      return serializeTicketPayment(Payment);
    } else if (request.getContentType() == "application/x-www-form-urlencoded") {
      CCInfo ccInfo = getCcInfoFromForm(request);
      Payment payment = this.paymentService.processPayment(ccInfo);
      return serializeCcPayment(payment);
    }
  }

}