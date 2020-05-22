public class Oracle9Dialect extends org.hibernate.dialect.Oracle9Dialect
{
    public Oracle9Dialect()
    {
        super();
        registerFunction("hour", new SQLFunctionTemplate(Hibernate.INTEGER, "to_number(to_char(?1, 'hh24'))"));
    }
}