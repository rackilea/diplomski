@Entity
public class Statement implements Serializable {
    @Id
    private long id;

    private String message;

    @OneToMany(mappedBy = "statementId")
    @MapKey(name = "statementConfigurationId")
    private Map<Long, StatementBalances> statementBalancesByConfigId;
}