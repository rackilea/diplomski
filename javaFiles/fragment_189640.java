public class MySQLDialect extends org.hibernate.dialect.MySQLDialect {
    public MySQLDialect() {
        super();
        registerFunction("bitwiseAnd", new SQLFunctionTemplate(StandardBasicTypes.BIG_INTEGER,
                "(?1 & ?2)"));
    }