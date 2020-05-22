@Entity
public class FileEntity {

    private static String BASE_DIR;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;