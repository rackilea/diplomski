@Autowired
 private Environment env;

@Bean
public DataSource dataSource() throws NamingException {
    return (DataSource) new JndiTemplate()
                             .lookup(env.getProperty("spring.datasource.jndi-name"));
 }