@Configuration
@EnableCassandraRepositories(basePackages = "my.base.package")
public class CassandraConfig extends AbstractCassandraConfiguration{

    @Override
    protected String getKeyspaceName() {
        return "keyspacename";
    }

    @Override
    public CustomConversions customConversions() {
        List<Converter> converters = new ArrayList<>();

        converters.add(new DateToLocalDateTime());
        converters.add(new LocalDateTimeToDate());

        return new CustomConversions(converters);
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
            new CassandraClusterFactoryBean();
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9142);
        return cluster;
    }

    @Bean
    public CassandraMappingContext cassandraMapping()
        throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}