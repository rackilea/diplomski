@Entity
    public class BankAdmin implements Serializable{

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "bcode", nullable=false)
    @Id private int bcode;

    @Column (name = "bname")
    private String bname;

    @Column (name = "address")
    private String address;

    @Column (name = "phno")
    private int phno;

    @OneToMany(mappedBy="bankAdmin",cascade=CascadeType.ALL)
    private Set<Card> cards;

    //Getters and Setters have been removed to reduce the amount of code.
    }