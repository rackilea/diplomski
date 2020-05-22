@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(field = "type", discriminatorType = DiscriminatorType.STRING)
public class User implements UserDetails {
  /* your original stuff */
}