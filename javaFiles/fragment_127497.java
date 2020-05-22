newGameButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        newGameActionPerformed(); // delegate this to a class method
     }
  });

  instructionGameButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        // call a controller object's methods
        if (myController != null) {
           myController.instructionGameAction();
        }
     }
  });

  exitButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        Menu.this.dispose(); // simple code can be called in-line
     }
  });