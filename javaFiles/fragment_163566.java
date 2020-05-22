public class Product {
        double price;
        int stockQuantity;
        int soldQuantity = 0;

    public Product(double p, int stkquantity){
        price = p;
        stockQuantity = stkquantity;
    }

    public double sellUnits(int amount){
        if(stockQuantity >= amount){
            stockQuantity -= amount;
            soldQuantity += amount;
            return price * amount;
        }
        return 0.0;    
    }
}