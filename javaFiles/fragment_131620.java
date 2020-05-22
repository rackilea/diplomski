@Entity
public class Owner {
    @Id
    private long id;

    @OneToMany(mappedBy="owner")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<WheelDrive, Car> carMap;
}

@Entity
public class Car {
    @Id
    private long id;

    @ManyToOne
    private Owner owner;

    @Column(name = "wheelDrive")
    @Enumerated(EnumType.STRING)
    private WheelDrive wheelDrive;

}

public enum WheelDrive {
    2WD, 
    4WD;             
}