@Singleton
public class ServiceClass1 {

    Provider<ConnectionClass> provider;

    @Inject
    public ServiceClass1(Provider<ConnectionClass> provider) {
        this.provider = provider;
    }
}