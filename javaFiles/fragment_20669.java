public void chooseFilePack() {
    Object selection = JOptionPange.showInputDialog(null, 
                           "Select file pack type", "File pack", 0, null, 
                           FilePackSubclassOption.values(), null);
    if (selection != null) {
        return ((FilePackSubclassOption)selection).createFilePack();
    }
    return null;
}