public void windowClosing(WindowEvent ev) {
    String savedData = "";
    for (Component c: getComponents()) {
        if (c instanceof JLabel) {
            savedData += ((JLabel)c).getText() + "\n";
        }
    }
    //Save Data to file
    //OR write to sqlite database in the current users row
}