@Entity
@Table(name = "main_error")
public class MainError {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String id;

    @JoinColumn(name = "error_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Error errorId;

    public MainError() {
    }

    public MainError(String id) {
        this.id = id;
    }

    //getter and setter methods
}