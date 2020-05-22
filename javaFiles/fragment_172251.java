public class Offer {
    private int price;
    private Date dateOfOffer;
    // etc.

    // The original constructor. Sets all the fields to the specified values
    public Offer(int price, Date dateOfOffer, double duration, HotelOnly hotelOnly) {
        this.price = price;
        this.dateOfOffer = dateOfOffer;
        // etc.
    }

    // A constructor that uses default values for all of the fields
    public Offer() {
        // Calls the top constructor with default values
        this(100, new Date("10-13-2015"), 14.5, new HotelOnly());
    }

    // A constructor that uses default values for all of the fields except price
    public Offer(int price) {
        // Calls the top constructor with default values, except price
        this(price, new Date("10-13-2015"), 14.5, new HotelOnly());
    }

    // A constructor that uses default values for all of the fields except Date and HotelOnly
    public Offer(Date date, HotelOnly hotelOnly) {
        this(100, date, 14.5, hotelOnly);
    }

    // A bunch more constructors of different combinations of default and specified values

}