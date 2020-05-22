public class CustomClass {

   @Inject
   IDBDAL dbDAL;

   // can be application context or activity context
   private Context mContext;

   public CustomClass() {
      // you can get context variable somewhere else 
      mContext = MyApplication.getAppContext(); 
      RoboGuice.getInjector(mContext).injectMembersWithoutViews(this);
      // from now. you can use dbDAL object
      dbDAL.doSomething(); // work like charm :)
   }
}