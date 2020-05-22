@Entity
@Table(name = "statement_configuration")
public class StatementConfiguration implements Serializable {
    @Id
    private long id;

    @OneToMany(mappedBy = "statementConfigurationId")
    private Collection<StatementBalances> statementBalances;

    private String name;
    private String currency;
}