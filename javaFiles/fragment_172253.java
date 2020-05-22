public class Offer {
    private int price = 100;
    private Date date = new Date("10-13-2015");
    // etc. Initialize with default values

    // Don't make any constructors

    // Have a getter for each field
    public int getPrice() {
        return price;
    }

    // Make your setters return the same object
    public Offer setPrice(int price) {
        // The same structure as in the builder class
        this.price = price;
        return this;
    }

    // etc. for each field

    // No need for OfferBuilder class or build() method
}