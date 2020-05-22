ChangeListener<? super Number> valueListener = (observable, oldValue, newValue) -> {
    boolean isOnMin = newValue.doubleValue() == slider.getMin();
    boolean isOnMax = newValue.doubleValue() == slider.getMax();
    if (!slider.isValueChanging() || isOnMin || isOnMax) {
        System.out.println("Value changed");
    }
};