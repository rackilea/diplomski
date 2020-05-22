@Module
public class StoreModule {
    private UserStore mStore;

    @Provides
    @Singleton
    public UserStore provideUserStore() {
        return getStore();
    }

    private UserStore getStore() {
        //lazy initialized and make sure thread safe
       if (null == mStore) {
           @synchronized(StoreModule.class) {
               if (null == mStore) {
                   mStore = new UserStore();
               }
           }
       }
       return mStore;
    }
}