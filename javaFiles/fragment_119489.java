public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jbtb) | e.getSource().equals(jbtw)) {
            timer.setInitialDelay(5000);
            timer.start();  

            if (coffees == 0) {
                jlbl.setText("Empty");
            } else {
                jlbl.setText("Select " + coffees);
            }
        }
        else {
            if (coffees - 1 >= 0) {
                coffees--;
                jlbl.setText("Ready " + coffees);               
            }
        }
    }