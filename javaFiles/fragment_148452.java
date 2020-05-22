public class Address {
        private String streetAddress;
        private int number;
        private String postalCode;
        private String city;
        private String state;
        private String country;

        public String toLongFormat(){
            return null; // stitch together your long format
        }

        public String toShortFormat(){
            return null; // stitch together your short format
        }

        public String toMailingLabelFormat(){
            return null; // stitch together your mailing label format
        }

        @Override
        public String toString(){
            return toShortFormat(); // your default format
        }
    }

}