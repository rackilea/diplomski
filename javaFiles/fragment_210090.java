public class Transactions extends TableImpl<TransactionsRecord> {

    ...

    public final TableField<TransactionsRecord, BigDecimal> AMOUNT = 
      createField("amount", org.jooq.impl.SQLDataType.DECIMAL(42, 10).nullable(false), this, "");

    public final TableField<TransactionsRecord, String> ACCOUNT = 
      createField("account", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    public final TableField<TransactionsRecord, String> ADDRESS = 
      createField("address", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    ...