public class MySQLDialect extends org.hibernate.dialect.MySQLDialect {

    public MySQLDialect() {
        super();
        registerFunction("bitand", new SQLFunctionTemplate(IntegerType.INSTANCE, "(?1 & ?2)"));
    }
}