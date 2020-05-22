@Entity
public class Course {
    ...
    @OneToMany
    @OrderColumn
    private List<Person> responsiblePersons;

    @OneToMany
    @OrderColumn
    private List<Course> consistsOf;
}

@Entity
public class Person {
    ...
    @OneToMany(mappedBy = "responsiblePerson")
    private List<Course> responsibleFor;
}