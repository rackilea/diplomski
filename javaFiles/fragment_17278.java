C.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!updateInProgress) {
                updateInProgress = true;
                F.setValue(toFahrenheit(C.getValue()));
                updateInProgress = false;
            }
            Clabel.setText("   C°: " + C.getValue());
        }
    });

    F.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!updateInProgress) {
                updateInProgress = true;
                C.setValue(toCelcius(F.getValue()));
                updateInProgress = false;
            }
            Flabel.setText("   F°: " + F.getValue());
        }
    });