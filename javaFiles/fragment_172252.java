public class Offer {
    private int price;
    // etc.

    public Offer(int price, ...) {
        // Same from above
    }

    public static class OfferBuilder {
        private int buildPrice = 100;
        private Date buildDate = new Date("10-13-2015");
        // etc. Initialize all these new "build" fields with default values

        public OfferBuilder setPrice(int price) {
            // Overrides the default value
            this.buildPrice = price;

            // Why this is here will become evident later
            return this;
        }

        public OfferBuilder setDateOfOffer(Date date) {
            this.buildDate = date;
            return this;
        }

        // etc. for each field

        public Offer build() {
            // Builds an offer with whatever values are stored
            return new Offer(price, date, duration, hotelOnly);
        }
    }
}