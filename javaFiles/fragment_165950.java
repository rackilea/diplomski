@Entity
public class UserDetails {
  @Id
  @GeneratedValue
  Long id;

  @ManyToOne
  Branch branch;
  ...
}

@Entity
public class Branch {
  @Id
  @GeneratedValue
  Long id;
  ...
}

public interface BranchRepository extends Repository<Branch, Long> {
  ...
}

public interface UserDetailsRepository extends Repository<UserDetails, Long> { 
  ...
}