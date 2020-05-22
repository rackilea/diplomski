@Module
public class SomethingModule {
    @Provides
    @Named("something")
    //scope if needed
    public Handler handler() {
        return new SomeImplementation();
    }
}