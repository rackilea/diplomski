@Component
public class Billing {

    private IService service;

    @Reference
    public void setService(IService service) {
        this.service = service;
    }

    public void billCustomer() {
         // Do some stuff related to billing, whatever.

         // Blah blah blah

         // Now call the service, even though it wasn't real Java because
         // the <T> type parameter was unbound, but who cares...
         service.foo(bar);

         // Yay.
    }