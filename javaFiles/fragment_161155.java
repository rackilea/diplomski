@Configuration
@EnableMongoRepositories(basePackages = {"my.app.repository"})
public class MongoConfiguration extends AbstractMongoConfiguration {

    ...

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(
                new InstantToLongConverter(), new LongToInstantConverter(),
                new LocalDateToStringConverter(), new StringToLocalDateConverter()));
    }
}