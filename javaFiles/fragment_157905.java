public class FooControl extends AbstractControl<LoginService> {

   @Override
   @Autowired
   public void setService(LoginService service) {
        this.service = service;
    }
}