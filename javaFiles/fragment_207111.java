@Path("/customers/{customerId}/invoices")
public class InvoiceRestService {

  @POST
  public EntityResponse add(@PathParam("customerId") String customerId, InvoiceResource invoiceResource) {
    return new EntityResponse(invoiceController.createInvoice(invoiceResource, customerId));
  }
}