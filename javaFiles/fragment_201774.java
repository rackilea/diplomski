@Entity
@Table(name="applications")
public class Application {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "app_id")
private int id;

@ManyToMany(mappedBy="applications",fetch=FetchType.EAGER)
private Set<Computer> computers = new HashSet<Computer>();

//Setter && Getters methods

}