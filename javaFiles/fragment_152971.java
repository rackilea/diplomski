String s = "c:/windows/regedit.exe";
File file = new File(s);

// Get metadata and create an icon
sun.awt.shell.ShellFolder sf =
        sun.awt.shell.ShellFolder.getShellFolder(file);
Icon icon = new ImageIcon(sf.getIcon(true));