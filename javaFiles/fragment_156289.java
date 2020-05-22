@Entity
public class Person {
    @ManyToOne
    Person supervisor;

    @OneToMany(mappedBy = "supervisor")
    Set<Person> supervised;
}