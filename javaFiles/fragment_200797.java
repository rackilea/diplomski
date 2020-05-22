@MappedSuperclass
public abstract class CommonFields{
    @Id
    @Column(name = "ID")
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}