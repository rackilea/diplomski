public JMenuItem createMenuItemWithListener(String text, 
                                            char mnemonic, 
                                            ActionListener action) {
    JMenuItem result = new JMenuItem(text);
    result.setMnemonic(mnemonic);
    result.addActionListener(action);
    return result;
}

public JMenuItem createMenuItemWithAction(char mnemonic, 
                                          Action action) {
    JMenuItem result = new JMenuItem(action);
    result.setMnemonic(mnemonic);
    return result;
}