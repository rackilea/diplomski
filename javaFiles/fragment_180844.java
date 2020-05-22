@Entity
public class Customer {

    @OneToMany
    private Set<Order> orders;

}

@Entity
public class Order {

    @Id
    private Integer id;

}