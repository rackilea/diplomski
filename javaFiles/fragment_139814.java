import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
public class GCApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(GCApplication.class, args);
    }

    @Primary
    @Bean
    public DataSource getDataSource(
        @Qualifier("first") DataSourceProperties first,
        @Qualifier("second") DataSourceProperties second)
    {
        int i = 0;
        final DataSource firstDataSource = first.initializeDataSourceBuilder().build();
        final DataSource secondDataSource = second.initializeDataSourceBuilder().build();
        try
        {
            firstDataSource.getConnection();
            return firstDataSource;
        } 
        catch (Exception e) 
        {
            return secondDataSource;
        }
    }

    @Primary
    @Bean("first")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties primaryDataSource()     
    {
        final DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://172.17.0.2:3306/gcdb?allowPublicKeyRetrieval=true&useSSL=false");
        dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setPassword("root");
        return dataSourceProperties;
    }

    @Bean("second")
    public DataSourceProperties secondaryDataSource() {
        final DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:h2:mem:gcdboff");
        dataSourceProperties.setDriverClassName("org.h2.Driver");
        dataSourceProperties.setUsername("root");
        dataSourceProperties.setPassword("root");
        return dataSourceProperties;
    }
}