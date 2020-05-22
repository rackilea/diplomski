@Entity
public class Person {
    @Id
    private String guid;
    private String firstName;
    @ManyToOne
    private Organisation organisation;
    ...
    ...
}