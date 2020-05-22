public class StandardCustomer extends Customer {
    // There's more - you fill in the blanks
    public double getTotalFees() { return 5.0*this.totalFees; }
}

public class PreferredCustomer extends Customer {
    // There's more - you fill in the blanks
    public double getTotalFees() { return this.totalFees; }
}

public class CustomerFactory {
    public Customer create(String type) {
        if ("preferred".equals(type.toLowerCase()) {
            return new PreferredCustomer();
        } else {
            return new StandardCustomer();
        }
    }
}