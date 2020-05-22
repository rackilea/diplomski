@Entity
@NamedQuery(name="User.findByEmailAddressAndLastName",
    query="select u from User u where u.emailAddress = ?1 and u.lastname = ?2")
public User{


}