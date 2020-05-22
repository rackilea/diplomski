import org.postgresql.ds.PGPoolingDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

@Configuration
class PostgreSQLDatasourceConfiguration {

  @Bean(name = 'dataSource')
  DataSource ds(@Value('${DATABASE_URL}') String databaseFullUrl) {
    assert databaseFullUrl, 'Database URL is required to start the application'

    URI uri = new URI(databaseFullUrl)
    def (_, dbUsername, dbPassword) = (uri.getUserInfo() =~ /(.*):(.*)/)[0]

    (DataSource) new PGPoolingDataSource().tap {
      url = "jdbc:postgresql://$uri.host:${uri.port}$uri.path"
      password = dbPassword
      user = dbUsername
    }
  }
}