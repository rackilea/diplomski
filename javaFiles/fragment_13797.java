formattedTextField.addPropertyChangeListener("value",
    new PropertyChangeListener() {
        @Override
        public void propertyChangeEvent(PropertyChangeEvent event) {
            Double newValue = (Double) event.getNewValue();
            if (newValue != null) {
                if (angle.isSelected()) {
                    double radians = Math.toRadians(newValue);
                    resultLabel.setText(
                        newValue = + " ° = " + radians + " radians");
                } else {
                    double degree = Math.toDegrees(newValue);
                    resultLabel.setText(
                        newValue + " radians = " + degree + " °");
                }
            }
        }
    });