@Entity
@Table(name="computers")
public class Computer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "computer_id")
private int id;

@ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
@JoinTable(name="computer_app", 
        joinColumns={@JoinColumn(name="computer_id")}, 
        inverseJoinColumns={@JoinColumn(name="app_id")})
private Set<Application> applications = new HashSet<Application>();

//Setter && Getters methods

}