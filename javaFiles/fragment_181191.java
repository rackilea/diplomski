@Entity
public class Status {

    public enum StatusEnum {
        STORED, APPROVED
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;
}