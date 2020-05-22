@Module(library = true )
public class ServiceModule {
    @Provides @Singleton
    IAccountService provideAccountStoreService(AccountService service) {
        return service;
    }

    @Provides @Singleton
    IAccountDAO accountDAO provideAccountDAO() {
        return new AccountDAO();
    }

}