abstract class Product {}
class ComputerPart extends Product {}
class Peripheral extends Product { }
class Cheese extends Product {} 
class Fruit extends Product {}
class Service extends Product {} 

abstract class GenericOrder<T extends Product> {
    protected final void addImpl(T t) {
    }
}

class ComputerOrder extends GenericOrder<Product> {
    void add(ComputerPart t) {
        addImpl(t);
    }
    void add(Peripheral t) {
        addImpl(t);
    }
    void add(Service t) {
        addImpl(t);
    }
}

class PartyTrayOrder  extends GenericOrder<Product> {
    void add(Cheese t) {
        addImpl(t);
    }
    void add(Fruit t) {
        addImpl(t);
    }
    void add(Service t) {
        addImpl(t);
    }
}