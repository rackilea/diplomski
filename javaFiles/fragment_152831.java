@Entity
public class User {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_home_address")
    private Address homeAddress;

    @ManyToOne
    @JoinColumn(name = "fk_work_address")
    private Address workAddress;

    // getters and setters
}