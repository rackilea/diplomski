@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    SessionKeyExchangerService provideSessionKeyExchangerService();
    AESCipherService provideCipherService();

    void inject(SplashScreenActivity splashScreenActivity); //does NOT support base class injection! Concrete classes only!
}