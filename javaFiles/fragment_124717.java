@Entity
public class Group {

    @PrimaryKey
    private long id;
    private String name;
    @Embedded
    private List<Team> teams;

    public Group() {

    }

    public Group(String name) {
        this.name = name;
    }

    /* getter and setter methods */