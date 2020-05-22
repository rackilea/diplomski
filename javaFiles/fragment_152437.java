public void validate() {
        Configuration<?> configuration = Validation.byDefaultProvider().configure();
        ValidatorFactory validatorFactory = configuration.messageInterpolator(new CustomMessageInterpolator()).buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Product p = new Product();
        Category cat = new Category();
        cat.setName("s"); //assume specified name is invalid
        p.setCategory(cat);

        Set<ConstraintViolation<Product>> violations = validator.validate(p);
        for(ConstraintViolation<Product> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }