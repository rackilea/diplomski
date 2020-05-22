@Entity
@Table(name = "customer_tab")
public class Customer {
    @OneToMany(mappedBy="customer")
    @OrderColumn(name="orders_index")
    public List<Order> getOrders() { return orders; }

}

@Entity
public class Order {
    @ManyToOne
    @JoinColumn(name = "customerId")
    // the name of this field should match the name specified
    // in your mappedBy annotation in the Customer class
    private Customer customer;
}