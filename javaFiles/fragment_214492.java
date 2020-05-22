@Entity
@QueryEntity
@Table(name = "users")
public class User {
  @OneToMany
  private Address address;
}

@Entity
@QueryEntity
@Table(name = "address")
public class Address {
  @ManyToOne
  private Country country;
}

@Entity
@QueryEntity
@Table(name = "country")
public class Country { }