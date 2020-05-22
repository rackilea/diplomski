//Setting the mnemonic when constructing a menu item:
menuItem = new JMenuItem("A text-only menu item",
                     KeyEvent.VK_H);

//Setting the mnemonic after creation time:
menuItem.setMnemonic(KeyEvent.VK_H);

//Setting the accelerator:
menuItem.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_H, ActionEvent.ALT_MASK));