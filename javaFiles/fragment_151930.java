public void increment(int steps) {
    SpinnerValueFactory<T> valueFactory = getValueFactory();
    if (valueFactory == null) {
        throw new IllegalStateException("Can't increment Spinner with a null SpinnerValueFactory");
    }
    commitEditorText();
    valueFactory.increment(steps);
}