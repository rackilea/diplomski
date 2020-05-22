public class FilterImpl implements Filter {
    private final Validator validator;

    public FilterImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public getValidator() {
         return this.validator;
    }

    //...
}

public class FilterFactory {
    private final ValidatorFactory validatorFactory = new ValidatorFactory();

    public Filter createFilter() {
        return new FilterImpl(valdatorFactory.createFilterValidator());
    }
}