abstract class BaseFruitBuilder<T extends FruitBuilder<T>> implements FruitBuilder<T> {

    String taste;

    T taste(String taste) {
       this.taste = taste;
       return returnThis();
    }

    protected abstract T returnThis();

     //...
}

class GrapseBuilderImpl extends BaseFruitBuilder<GrapesBuilder> {
    //...
    @Override
    protected T returnThis() {
        return this;
    }
}