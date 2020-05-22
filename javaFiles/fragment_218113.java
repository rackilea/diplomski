String dynamicPattern = ...;

ConstraintMapping mapping = new ConstraintMapping();
mapping.type( ContactInfo.class )
    .property( "workPhone", FIELD )
    .constraint( new PatternDef().regexp( dynamicPattern ) );

HibernateValidatorConfiguration config = 
    Validation.byProvider( HibernateValidator.class ).configure();
config.addMapping( mapping );

Validator validator = config.buildValidatorFactory().getValidator();