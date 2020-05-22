@Entity
public class RentalCarMileage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    @Column
    private BigDecimal mileage;
}

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "customer")
    private List<RentalCarMileage> rentals;

}

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "car")
    private List<RentalCarMileage> rentals;

}