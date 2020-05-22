public IntegerSpinnerValueFactory(@NamedArg("min") int min,
                                      @NamedArg("max") int max,
                                      @NamedArg("initialValue") int initialValue,
                                      @NamedArg("amountToStepBy") int amountToStepBy) {
        setMin(min);
        setMax(max);
        setAmountToStepBy(amountToStepBy);
        setConverter(new IntegerStringConverter());

        valueProperty().addListener((o, oldValue, newValue) -> {
            // when the value is set, we need to react to ensure it is a
            // valid value (and if not, blow up appropriately)
            if (newValue < getMin()) { 
                setValue(getMin());
            } else if (newValue > getMax()) {
                setValue(getMax());
            }
        });
        setValue(initialValue >= min && initialValue <= max ? initialValue : min);
    }