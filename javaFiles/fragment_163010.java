@Service
    public class TastService{

         private final Executor testAsync;

         @Autowire
         public TastService(Executor testAsync) {
             this.testAsync = testAsync;
         }

         public void runMyCode(){
            testAsync.submit()
         }
   }