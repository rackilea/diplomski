button1.setActionCommand("doAction1");

public void actionPerformed(ActionEvent event) {
    String actionCommand = event.getActionCommand();

    if (actionCommand.equals("doAction1")) {
        // button 1 pressed
    }
}