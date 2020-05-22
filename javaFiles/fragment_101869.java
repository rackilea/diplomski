@Entity
@Table(name = "my_classes")
public class MyClass {

    @Id
    @GeneratedValue
    private Long id;

    // ...

    @ManyToOne
    private City city;
}