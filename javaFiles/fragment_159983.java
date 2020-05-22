void bindEnablementButtonToValidationStatus(Button button, EMFDataBindingContext ctx) {

    IObservableValue buttonEnable = SWTObservables.observeEnabled(button);
    IObservableValue validationStatus = new AggregateValidationStatus(
            ctx.getValidationRealm(),
            ctx.getBindings(), 
            AggregateValidationStatus.MAX_SEVERITY);

    ctx.bindValue(buttonEnable, validationStatus, 
            new EMFUpdateValueStrategy(
                    UpdateValueStrategy.POLICY_NEVER), 
                    new EMFUpdateValueStrategy().setConverter(
                            new Converter(IStatus.class, Boolean.TYPE) {
                                public Object convert(Object fromObject) {
                                    return new Boolean(((IStatus)fromObject).isOK());
                                }
                            }));