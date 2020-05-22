public class GuiceConstraintValidationFactory implements ConstraintValidatorFactory {

    private ConstraintValidatorFactory delegate;
    private Set<ConstraintValidator> validators;

    @Inject
    public GuiceConstraintValidationFactory(final Set<ConstraintValidator> validators) {
        this.validators = validators;
        delegate = new ConstraintValidatorFactoryImpl();
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        for(ConstraintValidator<?, ?> validator : validators) {
            if(validator.getClass() == key) {
                return (T) validator;
            }
        }
        return delegate.getInstance(key);
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> instance) {
        delegate.releaseInstance(instance);
    }

}