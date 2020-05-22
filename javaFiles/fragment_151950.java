@Entity
public class Owner {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name")
    @NotNull(message="{NotNull}")
    @Size(min=2,max=15,message="{Size}")
    private String firstName;

    @NotNull(message="{NotNull}")
    @Size(min=2,max=15,message="{Size}")
    @Column(name = "last_name")
    private String lastName;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval="true")
    private Phone phone;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval="true")
    private Pet pet;