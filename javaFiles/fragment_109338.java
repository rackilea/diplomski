@Configuration
public class RepoRestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", itemValidator()); // POST (if needed)
        v.addValidator("beforeSave", itemValidator());   // PUT/PATCH
        super.configureValidatingRepositoryEventListener(v);
    }

    @Bean
    ListingValidator itemValidator() {
        return new ItemValidator();
    }
}