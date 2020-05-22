public interface AddressFormatter {
   String format(Address toFormat)
}

public class LongAddressFormatter implements AddressFormatter {
    @Override
    public String format(Address toFormat){
         return String.format("%sBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAHBLAH%n%s", toFormat.streetAddress, toFormat.postalCode)
    }
}


public class ShortAddressFormatter implements AddressFormatter {
    @Override
    public String format(Address toFormat){
         return String.format("%d", toFormat.number)
    }
}

public  class Address {
        private String streetAddress;
        private int number;
        private String postalCode;
        private String city;
        private String state;
        private String country;
        public  AddressFormatter formatter = new ShortAddressFormatter(); // just to avoid NPE

        public void setFormatter(AddressFormatter fr) { this.formatter = fr; }



        @Override
        public String toString(){
            return formatter.format(this); // your default format
        }
    }

def addrr = new Address(streetAddress:"1234 fun drive", postalCode:"11223", number:1)
addr.setFormatter(new LongAddressFormatter());
println "The address is ${addrr}"
addr.setFormatter(new ShortAddressFormatter());
println "The address is ${addrr}"