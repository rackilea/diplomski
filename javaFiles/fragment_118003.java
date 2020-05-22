private Something showMessage() {

    // null for 'console' mode or this if the enclosing type is a frame
    Component parentComponent = null; 
    Object message = "Make more selections?";
    String title = "Message";
    int optionType = JOptionPane.YES_NO_OPTION; // 2 buttons
    int messageType = JOptionPane.QUESTION_MESSAGE; // icon from style
    Icon icon = null;

    // String in the buttons!
    Object[] options = { "Yup!", "Nope!" };

    // option saves the index 'clicked'
    int option = JOptionPane.showOptionDialog(
            parentComponent, message, title, 
            optionType, messageType, icon,
            options, options[0]);

    switch (option) {
    case 0:
        // button with "Yup!"
        break;
    case 1:
        // button with "Nope!"
        break;
    default:
        // you close the dialog or press 'escape'
        break;
    }

    return Something;
}