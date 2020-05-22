public static void bindTogglable(CheckBox aCheckBox, BooleanExpression aBooleanExpression,
        Predicate<Boolean> aSuccess) {
    aCheckBox.setSelected(aBooleanExpression.get());
    aBooleanExpression.addListener((aObservable, aOld, aNew) -> {
        aCheckBox.setSelected(aNew);
    });

    aCheckBox.setOnAction(e -> {
        boolean value = aCheckBox.isSelected();
        boolean oldValue = aBooleanExpression.get();
        if (value != oldValue && !aSuccess.test(value)) {
            aCheckBox.setSelected(oldValue);
        }
    });
}