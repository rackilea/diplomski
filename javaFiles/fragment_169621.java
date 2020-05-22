public class FactoryImpl implements SimpleFactory {
    public Product createProduct(){
        // Return an instance of some subclass of Product
    }
}
public class StoreComposition {
    SimpleFactory factory = new FactoryImpl();
}