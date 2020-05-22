@Configuration
@EnableJpaRepositories(basePackages = {
        "pl.example.data.repository"
})
@EnableTransactionManagement
public class DataConf
{ ... }