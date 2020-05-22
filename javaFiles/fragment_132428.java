@Entity
@Table(name = "file")
public class MetaFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private int fileId;
    // getters, setters, constructors...

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "file")
    private RowCount rowCount;
}