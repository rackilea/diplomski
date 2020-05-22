@Entity
@Table(name="folder")
public class Folder {
    @Id
    private String reference;

    @OneToMany(mappedBy="folder", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Client> clients= new ArrayList<>();

    private Date createDate;

    //getters and setters
}


@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    //getters and setters
}