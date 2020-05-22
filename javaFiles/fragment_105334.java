public class FruitHandlerFactory<H extends FruitHandler<F>, F extends Fruit> {
    final Class<H> handlerClass;
    final Class<F> fruitClass;

    public FruitHandlerFactory(final Class<H> handlerClass, final Class<F> fruitClass) {
        this.handlerClass = handlerClass;
        this.fruitClass = fruitClass;
    }

    public H create() throws InstantiationException, IllegalAccessException {
        H handler = handlerClass.newInstance();
        handler.setFruit(fruitClass.newInstance());
        return handler;
    }
}