@Entity
class Customer {
  @EmbeddedId CustomerId id;
  boolean preferredCustomer;
}

@Embeddable
class CustomerId implements Serializable {
  @OneToOne
  @JoinColumns({
    @JoinColumn(name="userfirstname_fk", referencedColumnName="firstName"),
    @JoinColumn(name="userlastname_fk", referencedColumnName="lastName")
  }) 
  User user;
  String customerNumber;
}

@Entity 
class User {
  @EmbeddedId UserId id;
  Integer age;
}

@Embeddable
class UserId implements Serializable {
  String firstName;
  String lastName;
}