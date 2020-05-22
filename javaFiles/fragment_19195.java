abstract class BaseController {
    final Store store; 

    BaseController(Store store) {
        this.store = store;
    }
}

class MyController extends BaseController {
   private final Validator validator;

   @Inject
   public MyController(Validator validator, Store store) {
      super(store);
      this.validator = validator;
   }
}