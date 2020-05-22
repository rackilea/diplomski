@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

// Attributes.    
@Id
@Column(name="PERSON_ID", unique=true, nullable=false)    
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer personId;

@Column(name="NAME", nullable=false, length=50)      
private String name;

@Column(name="ADDRESS", nullable=false, length=100)
private String address;

@Column(name="TELEPHONE", nullable=false, length=10)
private String telephone;

@Column(name="EMAIL", nullable=false, length=50)
private String email;

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)     
private List<Book> books;
}