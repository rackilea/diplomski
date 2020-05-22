public class HeroModels extends BaseModels {

    static HeroModels instance;

    public static HeroModels instance() {
        instance = instance(HeroModels.class, instance);
        return instance;
    }

    @Override
    public void load() {
        System.out.println("Loading HeroModels...");
    }
}