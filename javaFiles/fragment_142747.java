import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class SqlSessionFactoryWrapper {

    private static final String  BI_CONFIG  = "mybatis-config.xml";

    private SqlSessionFactory getFactory(final String config, final String env) throws IOException {
        final Reader reader = Resources.getResourceAsReader(config);
        final Properties properties = new Properties();
        properties.load(Resources.getResourceAsReader("some.properties"));

        return new SqlSessionFactoryBuilder().build(reader, env, properties);
    }

    @Produces
    @ApplicationScoped
    @Named("A")
    public SqlSessionFactory getFactoryA() throws IOException {
        return this.getBiFactory(CONFIG, "A");
    }

    @Produces
    @ApplicationScoped
    @Named("B")
    public SqlSessionFactory getFactoryB() throws IOException {
        return this.getFactory(CONFIG, "B");
    }
}