@Module
public class MyModule {

    // ********************** CONTROLLERS **********************
    @Provides
    @IntoMap
    @Named("Controllers")
    @ClassKey(FirstController.class)
    static Object provideFirstController(DepA depA, DepB depB) {
        return new FirstController(depA, depB);
    }

    @Provides
    @IntoMap
    @Named("Controllers")
    @ClassKey(SecondController.class)
    static Object provideSecondController(DepA depA, DepC depC) {
        return new SecondController(depA, depC);
    }
}