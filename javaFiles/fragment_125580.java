@Entity
@Table(name="restaurant")
public class Restaurant {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="restaurant")
    private List<RestaurantTable> table = new ArrayList<RestaurantTable>();

}

@Entity
@Table(name="restaurant_table")
public class RestaurantTable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

}