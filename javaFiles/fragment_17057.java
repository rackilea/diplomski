JMenuItem mnuSortAlbum =new JMenuItem("by album");
    mnuSortAlbum.setMnemonic(KeyEvent.VK_M);
    mnuSortAlbum.setDisplayedMnemonicIndex(1);
    mnuSortAlbum.setActionCommand("album");
    mnuSortAlbum.addActionListener(this);
    mnuSort.add(mnuSortAlbum);