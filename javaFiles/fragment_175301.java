@Bean
public Validator validator () {

    ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
        .configure().constraintValidatorFactory(new SpringConstraintValidatorFactory(autowireCapableBeanFactory))
        .buildValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    return validator;
}