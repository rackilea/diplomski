@Entity
public class Owner {
    @Id
    private long id;

    @OneToMany(mappedBy="owner")
    @MapKey(name = "vin")
    private Map<String, Car> carMap;
}

@Entity
public class Car {
    @Id
    private long id;

    @ManyToOne
    private Owner owner;

    private String vin;

}