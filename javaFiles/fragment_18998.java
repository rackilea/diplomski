@SqlResultSetMapping(name="StudentMapping",
    classes={
        @ConstructorResult(targetClass=Student.class,
            columns={
                @ColumnResult(name="name", type=String.class),
                @ColumnResult(name="address", type=String.class),
                @ColumnResult(name="date_of_birth", type=String.class)
            })
    }
)
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String String name;
    private String address;
    private String dateOfBirth;

    public Student () {}

    public Student(String name, String address, String dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    // Setters and Getters
}