@Entity
public class Person {
    @ManyToOne
    Person supervisor;
    ...
}