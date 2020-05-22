try {
    Robot pressbot = new Robot();
    pressbot.keyPress(17); // Holds CTRL key.
    pressbot.keyPress(76); // Holds L key.
    pressbot.keyRelease(17); // Releases CTRL key.
    pressbot.keyRelease(76); // Releases L key.
} catch (AWTException ex) {
    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
}