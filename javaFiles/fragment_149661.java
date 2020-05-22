@Entity
@Table(name="persons")
public class Person {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Person parent;

    ...

}