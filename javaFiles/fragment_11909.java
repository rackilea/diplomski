@Entity
@Table(name = "statement_balances")
@IdClass(StatementBalancesId.class)
public class StatementBalances implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="statement_configuration_id")
    private StatementConfiguration statementConfigurationId;

    @Id
    @ManyToOne
    @JoinColumn(name="statement_id")
    private Statement statementId;

    @Column
    private long balance;
}