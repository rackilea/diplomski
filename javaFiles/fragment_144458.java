@Embeddable
public class Status {

    @Column(name = "status")
    Boolean status;

    public Status(Boolean status) {
        this.status = status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}