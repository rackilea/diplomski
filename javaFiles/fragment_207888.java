@Entity
@NamedQueries( {
    @NamedQuery(name = "Company.ALL",query = "SELECT c FROM Company c")
    @NamedQuery(name = "Company.ALL.WithPerson",query = "SELECT c FROM Company c join fetch c.personList")
})
class Company {
    @OneToMany(cascade = CascadeType.ALL)  // fetch=FetchType.EAGER <-ugly, but would work
    List<Person> personList = new LinkedList<Person>();
}