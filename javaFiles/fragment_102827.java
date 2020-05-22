public class SQLAddNVarCharDialect extends SQLServerDialect {

    public SQLAddNVarCharDialect(){
        super();

        registerColumnType( Types.NVARCHAR, 8000, "nvarchar($1)" );     
        registerColumnType( Types.NVARCHAR,  "nvarchar(255)" );     
    }
}