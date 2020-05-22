@Entity
public class MyObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data;

    @Version
    private Integer version; // this is version field
}