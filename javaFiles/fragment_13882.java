saveDataButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dateArray.clear();
            for (int i = 0; i < spinnerArray.size(); i++) {
                //.....
                model2.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        changedDate = ((SpinnerDateModel) e.getSource()).getDate();  // **** (A) ****
                        System.out.println(changedDate);
                    }
                });
                // ...
            }
        }
    });