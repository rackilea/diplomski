@Controller {
    @Inject FirstService fServ;
    @Inject SecondService sServ;

    @RequestMapping
    handleHttpRequest() {
          fServ.invokeFirstTransactional();
          sServ.invokeSecondTransactional();
    }
}
FirstService {
   @Transactional
   void invokeFirstTransactional() {
        // Session object system hashcode = 187000543
        // Thread object system hashcode = 167000522

        // Transaction_ID in database = 650
   }
}
SecondService {
   @Transactional
   void invokeSecondTransactional() {
        // Session object system hashcode = 187000543
        // Thread object system hashcode = 167000522

        // Transaction_ID in database = 651
   }
}