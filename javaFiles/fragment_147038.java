@Entity
public class Folder {

    @Id
    @Column(name="PK_FOLDER")
    private int id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="FK_PARENT_FOLDER")
    public Folder parentFolder;

    @OneToMany(mappedBy="parentFolder")
    public List<Folder> subFolders = new ArrayList<Folder>();

}