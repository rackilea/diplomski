@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue
    @Column(name="Id")
    @JsonProperty("Id")
    private int id;


    @Column(name="Name", nullable=false)
    @JsonProperty("Name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}