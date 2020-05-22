@Entity
public class Request {
    @Id
    @Column(name = "req_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private User visitor;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    // ...
}