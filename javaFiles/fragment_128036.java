public class Customer {
    private String name;    
    private Order order

    private Customer(CustomerBuilder builder) {
        this.name = builder.name;
        this.order = builder.order;
    }

    public Customer replace(Order order) {
        return new CustomerBuilder().name(this.name).order(order).build();
    }

    public static class CustomerBuilder {
        private String name;    
        private Order order

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}