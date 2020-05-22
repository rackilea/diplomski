@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private long person_id;    

    @Column(name = "name")
    private String name;

    @Column(name = "Address")
    private String Address;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person" )
    private Set<Phone> phone;

    // Getters and Setters

}

@Entity
@Table(name = "phone")
public class Phone{

    @Id
    @GeneratedValue
    @Column(name = "phone_id")
    private long phone_id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;

    // Getters and Setters

}