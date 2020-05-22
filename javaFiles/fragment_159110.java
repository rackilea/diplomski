@Configuration@ EnableConfigurationProperties
public class AppConfig {

    @Bean@ ConfigurationProperties(prefix = "spring.datasource.primary")
    public JndiPropertyHolder primary() {
        return new JndiPropertyHolder();
    }

    @Bean@ Primary
    public DataSource primaryDataSource() {
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        DataSource dataSource = dataSourceLookup.getDataSource(primary().getJndiName());
        return dataSource;
    }

    @Bean@ ConfigurationProperties(prefix = "spring.datasource.secondary")
    public JndiPropertyHolder secondary() {
        return new JndiPropertyHolder();
    }

    @Bean
    public DataSource secondaryDataSource() {
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        DataSource dataSource = dataSourceLookup.getDataSource(secondary().getJndiName());
        return dataSource;
    }

    private static class JndiPropertyHolder {
        private String jndiName;

        public String getJndiName() {
            return jndiName;
        }

        public void setJndiName(String jndiName) {
            this.jndiName = jndiName;
        }
    }
}