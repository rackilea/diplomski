public class ValidationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GuiceConstraintValidationFactory.class).in(Singleton.class);
    }

    @Provides
    public Validator validator(GuiceConstraintValidationFactory validatoFactory) {
        return Validation.byDefaultProvider().configure().constraintValidatorFactory(validatoFactory).buildValidatorFactory().getValidator();
    }

}