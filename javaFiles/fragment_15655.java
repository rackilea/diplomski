@Entity
public class Project {
    private Long id;
    private int statusCode;

    @Id @GeneratedValue
    public Long getId() {
        return this.id;
    }
    private void setId(Long id) {
        this.id = id;
    }

    @Transient
    public Status getStatus () {
        return Status.parse(this.statusCode);
    }
    public void setStatus(Status status) {
        this.statusCode = status.getCode();
    }

    protected int getStatusCode() {
        return statusCode;
    }
    protected void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}