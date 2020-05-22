OK.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int h, m;
            h = (Integer) hourSpinner.getValue();
            m = (Integer) minuteSpinner.getValue();
            parentPanel.createNewEvent(parentPanel.selectedBox, parentWindow,       textPane.getText(), h, m);
            try {
                parentPanel.selectedBox.saveEventsToFile();
            } catch (ExeptionThaIsThrownBySaveEventsMethod e) {
                // display error
            }
            dispose();
        }
    });