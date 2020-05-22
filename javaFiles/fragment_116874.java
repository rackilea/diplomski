public interface Factory<T> {
    T create();
}

// ...

public void processObject(Map<?, ?> map, Factory<Type> factory) {
    // Calls the factory to create a new Type
    Type item = factory.create();

    // ...
}

// Factory implementation for BaseItem
public class BaseItemFactory implements Factory<BaseItem> {
    @Override
    public BaseItem create() {
        return new BaseItem();
    }
}