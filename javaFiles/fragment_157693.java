@Module(
        injects = {
                PlayerApplication.class,
                CryptoService.class,
                SerializationService.class,
                PlayerApplicationService.class
        },
        complete = true,
        library = true
)
public class PlayerApplicationModule {
    private PlayerApplication application;

    public PlayerApplicationModule(PlayerApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    public CipherFactory provideCipherFactory() {
        return new CipherFactory();
    }

    @Provides
    @Singleton
    public ObjectMapper provideObjectMapper() {
        return new ObjectMapper();
    }

}