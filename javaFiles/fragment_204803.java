@Entity
@Table(name = "support_ticket")
public class SupportTicket implements Serializable {

    private String projectId;
    private String ticketNum;

    public SupportTicket() {
    }

    public SupportTicket(String projectId) {
        this.projectId = projectId;
    }

    @Column(name = "project", unique = true, nullable = false, length = 10)
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Id
    @Column(name = "ticket", nullable = false, insertable = false, updatable = false)
    @GenericGenerator(
            name = "custom-sequence",
            strategy = "your.package.CustomGenerator"
    )
    @GeneratedValue(generator = "custom-sequence")
    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }
}