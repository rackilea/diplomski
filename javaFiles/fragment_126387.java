@Module
public class SimpleModule {

    @Provides
    Cooker providerCooker() {
        return new Cooker("tom", "natie");
    }

    @Provides
    CoffeeMaker provideCoffeeMaker(Cooker cooker) {
        return new SimpleMaker(cooker);
    }

}