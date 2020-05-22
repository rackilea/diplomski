@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
@EnableCassandraRepositories(basePackages = "org.baeldung.spring.data.cassandra.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {
private static final Log LOGGER = LogFactory.getLog(CassandraConfig.class);

@Autowired
private Environment environment;

@Override
protected String getKeyspaceName() {
    return environment.getProperty("cassandra.keyspace");
}

@Override
@Bean
public CassandraClusterFactoryBean cluster() {
    final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
    cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
    cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
    LOGGER.info("Cluster created with contact points [" + environment.getProperty("cassandra.contactpoints") + "] " + "& port [" + Integer.parseInt(environment.getProperty("cassandra.port")) + "].");
    return cluster;
}


@Bean
public CassandraMappingContext mappingContext() throws ClassNotFoundException {
    BasicCassandraMappingContext mappingContext = new BasicCassandraMappingContext();
    mappingContext.setInitialEntitySet(CassandraEntityClassScanner.scan("org.baeldung.spring.data.cassandra.model"));
    mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(),getKeyspaceName()));
    return mappingContext;
}

@Bean
public CassandraConverter converter() throws ClassNotFoundException {
    return new MappingCassandraConverter(mappingContext());
}

@Bean
public CassandraSessionFactoryBean session() throws ClassNotFoundException {
    CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
    session.setCluster(cluster().getObject());
    session.setKeyspaceName(getKeyspaceName());
    session.setConverter(converter());
    session.setSchemaAction(SchemaAction.RECREATE);
    return session;
  }
}