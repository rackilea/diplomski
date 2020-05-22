@Configuration
@EnableMongoRepositories(basePackages = {"com.tryton.repositories"})
@ConfigurationProperties("foo")
public class MongoConfig extends AbstractMongoConfiguration {
      [...]
}