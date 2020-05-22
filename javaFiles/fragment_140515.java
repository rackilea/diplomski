@Module(library=true)
public class ProviderModule {
    @Provides
    public ToInject provideToInject(){
        return new ToInjectConcrete1();
    }
}