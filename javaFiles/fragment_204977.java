@Entity
@Data
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne(optional = false)
    private Course course;

    public Student() {
    }

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }
}