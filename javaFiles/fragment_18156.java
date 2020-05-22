@Entity
@Table(name="FILE", schema="COMMON")
public class File {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="ID")
        private Long id;

        @Column(name = "FILE_NAME")
        private String fileName;

        @OneToOne(mappedBy = "file", cascade = CascadeType.ALL,
           fetch = FetchType.LAZY, optional = false)
        private FileContent details;  

        //constructors getters and setters

    }