Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
Set<ConstraintViolation<Model>> violations = validator.validate(model, First.class);

if(violations.isEmpty()){
     violations = validator.validate(model, Second.class);
}