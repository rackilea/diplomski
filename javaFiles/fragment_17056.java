JMenuItem mnuSortAlbum =new JMenuItem("by album");
    mnuSort.setMnemonic(KeyEvent.VK_M);
    mnuSort.setDisplayedMnemonicIndex(1);
    mnuSort.add(mnuSortAlbum);
    mnuSort.setActionCommand("album");
    mnuSort.addActionListener(this);