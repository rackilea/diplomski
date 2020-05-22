import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.JtaTransactionManagerFactoryBean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.data.neo4j.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@EnableNeo4jRepositories(basePackages = { "it.smartblue.mcba.neo4j.repository" })
@Configuration
public class Neo4jConfig extends Neo4jConfiguration {

    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Bean
    public SpringRestGraphDatabase graphDatabaseService() {
        return new SpringRestGraphDatabase("http://192.168.11.186:7474/db/data");
    }

    @Override
    @Bean(name = "transactionManager")
    public PlatformTransactionManager neo4jTransactionManager() throws Exception {
        return new ChainedTransactionManager(new JpaTransactionManager(entityManagerFactory.getObject()),
                new JtaTransactionManagerFactoryBean(graphDatabaseService()).getObject());
    }
}