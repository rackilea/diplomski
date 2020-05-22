@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class AppUser implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    @OneToMany(mappedBy = "appUser" , fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private Collection<Project> projects = new ArrayList<>();


    @OneToMany(mappedBy = "appUser" , fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Intervention> interventions = new ArrayList<>();

    @OneToMany(mappedBy = "appUser" , fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Contrat> contrats = new ArrayList<>();

}