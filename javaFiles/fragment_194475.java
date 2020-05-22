private someActionPerformedMethod() {
    // boolean representing when the username/password test is OK
    boolean[] loopItems = { false, false, false, true, false };
    boolean userFound = false;

    // you'll of course be using a while loop here
    for (boolean loopItem : loopItems) {
        if (loopItem) {
            userFound = true;
            // do something with user data
            break;              
        }
    }
    if (!userFound) {
        JOptionPane.showMessageDialog(null, "Login failed");
    }
}