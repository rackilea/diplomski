class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot 
                                         implements MethodSecurityExpressionOperations {
    private final FlatRepository flatRepository;

    CustomMethodSecurityExpressionRoot(
            final Authentication authentication,
            final FlatRepository flatRepository) {
        super(authentication);
        this.flatRepository = flatRepository;
    }

    ...
}