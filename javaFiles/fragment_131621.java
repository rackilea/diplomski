@Entity
public class Owner {
    @Id
    private long id;

    @OneToMany(mappedBy="owner")
    @MapKeyTemporal(TemporalType.TIMESTAMP)
    private Map<Date, Car> carMap;
}

@Entity
public class Car {
    @Id
    private long id;

    @ManyToOne
    private Owner owner;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on")
    private Calendar createdOn;         
}