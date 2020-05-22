private someActionPerformedMethod() {
    // boolean representing when the username/password test is OK
    boolean[] loopItems = { false, false, false, true, false };
    for (boolean loopItem : loopItems) {
        if (loopItem) {
            break;
        } else {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
    }
}