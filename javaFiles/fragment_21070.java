@Entity
@Table(name = "restaurant")
public class Restaurant {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="restaurant")
    private List<Booking> bookings;

}

@Entity
@Table(name = "channel")
public class Channel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="channel")
    private List<Booking> bookings;

}

@Entity
@Table(name = "booking")
public class Booking {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id") 
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id") 
    private Channel channel;

}