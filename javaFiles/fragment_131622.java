@Entity
public class Owner {
    @Id
    private long id;

    @OneToMany(mappedBy="owner")
    @MapKeyJoinColumn(name="manufacturer_id")
    private Map<Manufacturer, Car> carMap;
}

@Entity
public class Car {
    @Id
    private long id;

    @ManyToOne
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;          
}

@Entity
public class Manufacturer {
    @Id
    private long id;

    private String name;
}