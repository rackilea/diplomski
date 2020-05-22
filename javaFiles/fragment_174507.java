import org.hibernate.id.IdentifierGenerator;

public class SharedGenerator implements IdentifierGenerator {
    private static final IdentifierGenerator underlyingGenerator = new UUIDGenerator();

    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
        return underlyingGenerator.generate(sessionImplementor, o);
    }
}