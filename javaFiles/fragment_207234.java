@Entity
@NamedQuery(name="Process.findAll", query="select p from Process p ")
public class Process {

    @Id
    private long id;
    private String name;

    @Transient
    private transient Status status; //actual enum; not stored in db
        @Column(name="STATUS")  
    private int statusCode; // enum code gets stored in db

    @PrePersist
    void populateDBFields(){
        statusCode = status.getCode();
    }

    @PostLoad
    void populateTransientFields(){
        status = Status.valueOf(statusCode);
    }
    public long getId() {
        return id;
    }
        public void setId(long id) {
        this.id = id;
    }
        public String getName() {
        return name;
    }
        public void setName(String name) {
        this.name = name;
    }
        public Status getStatus() {
        return status;
    }
        public void setStatus(Status status) {
        this.status = status;
    }
}