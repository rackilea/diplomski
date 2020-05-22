ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
        .configure()
        .buildValidatorFactory();

String whatIwantToPass = runtimelogic( args );

Validator validator = validatorFactory.unwrap( HibernateValidatorFactory.class )
        .usingContext()
        .constraintValidatorPayload( whatIwantToPass )
        .getValidator();

// use the validator with the constraint validator payload 
vehicle veh1 = new vehicle();
Set<ConstraintViolation<vehicle>> constraintViolations = validator.validate( veh1 );