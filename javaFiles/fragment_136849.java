@Entity
public class User extends Model {

  // Use this interface to mark out the subset of validation rules to run when updating a user's first name
  public interface FirstNameStep {}

  @Id
  public Long id;

  @Required(groups = FirstNameStep.class)
  public String firstName;

  // This isn't required when updating a user's first name
  @Required
  public String lastName;
}