public void actionPerformed(ActionEvent event) {
     if (event.getSource().equals(cmd)) {
        int number = 0;
        try {
           number = Integer.parseInt(cmd.getText());
        } catch (NumberFormatException e) {
           // TODO: figure out what to do if bad input entered
        }

        // ..........