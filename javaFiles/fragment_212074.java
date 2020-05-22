import org.hibernate.dialect.DerbyDialect;

public class CustomDerbyDialect extends DerbyDialect {
    public boolean supportsNotNullUnique() {
        return true;
    }
}