slider.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent event) {
        if (!slider.getValueIsAdjusting()) {
            double v = slider.getValue() / 10.0;
            System.out.println("value: "+v);
        }
    }
});