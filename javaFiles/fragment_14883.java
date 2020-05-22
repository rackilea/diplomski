PropertyChangeListener l = new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String text = evt.getNewValue() != null ? evt.getNewValue().toString() : "";
            label.setText(evt.getNewValue());
        }
    };
    formattedTextField.addPropertyChangeListener("value", l);