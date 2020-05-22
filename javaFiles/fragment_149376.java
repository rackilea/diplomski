@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.xplorg.model"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("your server ip (like localhost in local)");
    }

    @Override
    protected String getBucketName() {
        return "username";
    }

    @Override
    protected String getBucketPassword() {
        return "passsword";
    }
}