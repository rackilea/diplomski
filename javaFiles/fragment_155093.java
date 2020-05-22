jRadioButtonESPRINCIPAL.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jRadioButtonESPRINCIPAL.equals(lastSelectedRadioButton)) {
                buttonGroup1.clearSelection();
                lastSelectedRadioButton = null;
            }
            else {
                lastSelectedRadioButton = jRadioButtonESPRINCIPAL;
            }
        }
    });

    jRadioButtonESSECUNDARIO.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jRadioButtonESSECUNDARIO.equals(lastSelectedRadioButton)) {
                buttonGroup1.clearSelection();
                lastSelectedRadioButton = null;
            }
            else {
                lastSelectedRadioButton = jRadioButtonESSECUNDARIO;
            }
        }
    });