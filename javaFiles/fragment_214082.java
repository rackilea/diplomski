@MappedSuperclass
public abstract class AbstractUser {
    //all your columns/JPA mapping go here
}

@Entity
@Table(name="USERS")
public class User extends AbstractUser {}

@Entity
@Table(name="V_USERS")
public class VUser extends AbstractUser {}