@Entity
@Table(name="users")
@ForeignKey(name="userPersonId")
public class User extends Person  {

    private String userName;
    private String password;
    private Date registrationDate;
    private Set<? extends Person> contacts;

    @ManyToMany(targetEntity = com.blah.Person.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ForeignKey(name = "contactUserId", inverseName = "contactPersonId")
    @JoinTable(name = "contact", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "personId")})
    public Set<? extends Person> getContacts() {
        return contacts;
    }

...

}