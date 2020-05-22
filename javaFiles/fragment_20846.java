package inventory3;

public class ItemDetails extends Items {
    private String Name;
    private double pNumber, Units, Price;

    public ItemDetails(String Name, double pNumber, double Units, double Price) {
        this.Name = Name;
        this.pNumber = pNumber;
        this.Units = Units;
        this.Price = Price;
    }

    // getters and setters....

    // The @Override is optional, but recommended.
    @Override
    public double calculateTotalPrice() {
        return Units * Price * 1.05; // From my understanding this is what you want to do
    }
}