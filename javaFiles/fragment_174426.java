@Entity
@Table(name="OBJECT")
public class SomeObject {
    private int id;
    private String name;
    private Timestamp createdOn;
    private Timestamp editedOn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CREATED_ON")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "EDITED_ON")
    public Timestamp getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(Timestamp editedOn) {
        this.editedOn = editedOn;
    }

    @PrePersist
    public void setDates() {
        createdOn = LocalDateTime.now();
        editedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void setEditedOn() {
        editedOn = LocalDateTime.now();
    }
}