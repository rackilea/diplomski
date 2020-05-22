public class ModifiedSQLServerDialect extends SQLServer2008Dialect {
    public ModifiedSQLServerDialect () {
        super();
        registerColumnType( Types.TIMESTAMP, "datetime" );
    }
}