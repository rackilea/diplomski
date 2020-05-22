LoginPanel loginPane = new LoginPanel();
int option = JOptionPane.showOptionDialog(
     this, // A reference to the parent component
     loginPane,
     "Login", // Title
     JOptionPane.YES_NO_OPTION,
     JOptionPane.QUESTION_MESSAGE,
     null, // You can supply your own icon it if you want
     new Object[]{"Login", "Cancel"}, // The available options to the user
     "Login" // The "initial" option
     );
if (option == 0) {
    // Attempt login...
}