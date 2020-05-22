@Entity
@Table(name="new_students")
public class NewStudent {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")  
private int id;

@Column(name="first_name")
@NotNull(message="Required!")
@Size(min=3, message="At least 3 characters")
@Pattern(regexp="[A-Za-z]+", message="Invalid name")
private String firstName;

@Column(name="last_name")
@NotNull(message="Required!")
@Size(min=3, message="At least 3 characters")
@Pattern(regexp="[A-Za-z]+", message="Invalid last name")
private String lastName;

@NotNull(message="Select the country!")
@Column(name="country")
private String country;