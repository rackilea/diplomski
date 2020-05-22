class ItemFactoryContainer() {

    private Map<String, ItemFactory> factories = new HashMap<>();

    public void register(String name, ItemFactory factory) {
        factories.put(name, factory);
    }

    public ItemFactory getFactory(String name) {
        return factories.get(name);
    }
}

public class ItemFactoryTest {

    public static void main(String...args) {

        ItemFactoryContainer factoryContainer = new ItemFactoryContainer();

        factoryContainer.register("choclate", new ChocolateFactory ());
        factoryContainer.register("cake", new CakeFactory ());
        factoryContainer.register("iceCream", new IceCreamFactory  ());

        Chocolate choclate = factoryContainer.getFactory("choclate").getItem();
        Cake cake = factoryContainer.getFactory("cake").getItem();
    }
}