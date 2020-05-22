@Entity
@Data
@AllArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Transient
    private Long total;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }
}