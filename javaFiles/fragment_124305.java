@Entity
@Table(name = "POI")
public class PointOfInterest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poi_seq_poiid_generator")
    @SequenceGenerator(name = "poi_seq_poiid_generator", sequenceName = "poi_seq_poiid", allocationSize = 1)
    @Column(name = "POI_ID")
    private Long id;

    @OneToOne(mappedBy = "poi", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @Column
    private String name;

    ...
}

@Entity
@Table(name = "Address")
public class Address implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private PointOfInterest poi;

    @Column
    private String name;

    ...
}