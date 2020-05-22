@Entity
    public class Card implements Serializable {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cname", unique=true)
    @Id private int cname;

    @Column (name = "ctype")
    private String ctype;

    @Column (name = "min_sal")
    private int min_sal;

    @Column (name = "year_fee")
    private int year_fee;

    @Column (name = "rewards")
    private String rewards;

    @Column (name = "jperks")
    private String jperks;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id", nullable=false)
    private BankAdmin bankAdmin;

    public Card(){}

    public Card(String ctype, int min_sal, int year_fee, String rewards, String jperks, BankAdmin b){
        this.ctype=ctype;
        this.min_sal=min_sal;
        this.year_fee=year_fee;
        this.jperks=jperks;
        this.rewards=rewards;
        this.bankAdmin=b;
    } 

    public BankAdmin getBankAdmin() {
        return bankAdmin;
    }
    public void setBankAdmin(BankAdmin bankAdmin) {
        this.bankAdmin = bankAdmin;
    }
    }