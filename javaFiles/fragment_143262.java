public class Car extends Transport {    
    public Car(String name, double price) {
        super(name, price);
    }

    @Override
    public double carPrice(){
        return super.carPrice() * 1.5;
    }
}