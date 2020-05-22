@Document
public class User {
    private String name;
    private List<Address> addresses = new ArrayList<>();

    // ctr, getters, setters...

    public static class Address {
        private String city;

        public Address(String city) { 
            this.city = city;
        }

        // getters, setters...
    }
}