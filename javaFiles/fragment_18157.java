@Entity
@Table(name="FILE_CONTENT", schema="COMMON")
public class FileContent{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "FILE_NAME")
    private String fileName;  

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    private File file;   

    //constructors getters and setters
}