ValidatorFactory validatorFactory = Validation
    .byDefaultProvider()
    .configure()
    .addMapping(...) //input stream with an XML constraint mapping
    .addMapping(...) //another input stream with an XML constraint mapping
    .buildValidatorFactory();