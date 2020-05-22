ChangeListener<? super Boolean> valueChangingListener = (observable, oldUpdating, newUpdating) -> {
    double value = slider.getValue();
    boolean notUpdatingAnymore = oldUpdating && !newUpdating;
    boolean isOnExtreme = value == slider.getMin() || value == slider.getMax();
    if (notUpdatingAnymore && isOnExtreme) {
        System.out.println("Value changed");
    }
};

slider.valueChangingProperty().addListener(valueChangingListener);