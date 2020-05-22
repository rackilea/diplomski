@Entity
public class Person {

    ...
    @ElementCollection
    private Set<PersonGroup> person;