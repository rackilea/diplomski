@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Audited
public abstract class AbstractUser{..}

@Entity
@Audited
public class Admin extends AbstractUser{ .. }

@Entity
@Audited
public class OtherUser extends AbstractUser{ .. }