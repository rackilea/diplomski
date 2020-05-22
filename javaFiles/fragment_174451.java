Validator validator Validation.byProvider(HibernateValidator.class)
    .configure()
    .messageInterpolator(
        new ResourceBundleMessageInterpolator(
            new MyResourceBundleLocator() ) )
    .buildValidatorFactory()
    .getValidator();