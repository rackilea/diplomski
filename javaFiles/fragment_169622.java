public class StoreInheritance implements SimpleFactory {
    SimpleFactory factory = this;
    public Product createProduct(){
        // Return an instance of some subclass of Product
    }
}