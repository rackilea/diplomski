JFileChooser fileopen = new JFileChooser();
    int ret = fileopen.showDialog(null, "Open file");
    if (ret == JFileChooser.APPROVE_OPTION) {

        File file = fileopen.getSelectedFile();
        ImageIcon icon = new ImageIcon(file.getPath());
        jLabel1.setIcon(icon);
    }