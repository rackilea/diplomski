@Data
@Entity
public class MyEntity {

    @Id
    private Long id;

    @Column(lenght = 16, nullable = false)
    private String someField;
}