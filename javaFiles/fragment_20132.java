@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;

    @OneToMany(mappedBy="payerAccount", fetch = FetchType.EAGER)
    private Collection<Payments> payers;

    @OneToMany(mappedBy="receiverAccount", fetch = FetchType.EAGER)
    private Collection<Payments> receivers;


    /* GETTERS AND SETTERS */
}

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double ammount;

    @ManyToOne
    @JoinColumn(name="payer_account_id")
    private Account payerAccount;

    @ManyToOne
    @JoinColumn(name="recever_account_id")
    private Account receiverAccount;

    /* GETTERS AND SETTERS */

}