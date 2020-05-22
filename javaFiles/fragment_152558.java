@Configuration
public class AdminClientConfig {

    private final JdbcTemplate jdbcTemplate;
    private final Environment environment;

    public AdminClientConfig(JdbcTemplate jdbcTemplate,
        Environment environment) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    @Bean
    public ClientProperties clientProperties() {
        ClientProperties cp = new ClientProperties(environment);

        cp.setUsername(getUsername());
        cp.setPassword(getPassword());

        return cp;
    }

    private String getUsername() {
        String username = jdbcTemplate.queryForObject(
            "select username from AnyTable where id = ?",
            new Object[] { "123" }, String.class);
        return username;
    }

    private String getPassword() {
        String password = jdbcTemplate.queryForObject(
            "select password from AnyTable where id = ?",
            new Object[] { "123" }, String.class);
        return password;
    }
}