import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
... 

@Length(max = 40, message = "First name is too long") 
@NotEmpty(message = "First Name is required.") 
@Column(name = "FIRST_NAME") 
private String firstName;