@RequestScoped //Or whichever scope
public class StuffService {

   @Inject
   private Instance<SomethingData> somethingData;

   public void doStuff() {
       //You need to take care here, that the somethingData.get() may return null
       somethingData.get().soSomething();
   }
}