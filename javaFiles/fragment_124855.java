@Entity
public class Machine {

    @Id
    private long id;

    @OneToMany(mappedBy = "machine")
    private List<MachineLine> lines;

    // ...
}