public class RegistrationPage extends WebPage {

@Inject
public RegistrationPage() {
    add(new RegistrationForm());            
}

---
private static class RegistrationForm extends Form {
   RegistrationService service;

      @Inject
     public void setRegistrationService (RegistrationService  service){
     this.service = service;
        }
    public RegistrationForm() {
        // setup
    }

    protected void onSubmit() {
       service.doSomething();
    }
}
}