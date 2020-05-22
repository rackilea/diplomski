@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column (name = "code")
    private String code;

    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<User> users;
}

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;
}