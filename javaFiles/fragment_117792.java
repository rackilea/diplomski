interface Product {}

interface ComputerProduct extends Product {}
class ComputerPart implements ComputerProduct  {}
class Peripheral implements ComputerProduct  {}

interface PartyTrayProduct extends Product {}
class Cheese implements PartyTrayProduct{} 
class Fruit implements PartyTrayProduct{}

class Service implements Product {} 
class DeliveryService implements PartyTrayProduct{} 
class AssemblyService implements ComputerProduct  {}

class Salad implements PartyTrayProduct{} // A new PartyTrayProduct

// Entirely new product type:
interface CarProduct extends Product {}
class CarPart implements CarProduct  {}
class CarInterior implements CarProduct  {}

class GenericOrder<T extends Product> {
    public void add(T t) { }
}

public class ProductExample2 {
    public static void main(String[] args) {

        GenericOrder<ComputerProduct> c = new GenericOrder<ComputerProduct>();
        c.add(new ComputerPart());
        c.add(new Peripheral());
        //c.add(new Cheese()); // Not allowed
        //c.add(new Fruit()); // Not allowed
        c.add(new AssemblyService());

        GenericOrder<PartyTrayProduct> p = new GenericOrder<PartyTrayProduct>();
        //p.add(new ComputerPart());  // Not allowed
        //p.add(new Peripheral());  // Not allowed
        p.add(new Cheese());
        p.add(new Fruit());
        p.add(new Salad()); // Just add it...
        p.add(new DeliveryService());

        // Easy to extend:
        GenericOrder<CarProduct> e = new GenericOrder<CarProduct>();
        e.add(new CarPart());
        e.add(new CarInterior());
    }
}