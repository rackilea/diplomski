class BrowseButton extends JButton {

    public BrowseButton(String name, final JPanel pane) {

        super(name);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileopen = new JFileChooser();             
                FileFilter filter = new FileNameExtensionFilter("dwg files", "dwg");
                fileopen.addChoosableFileFilter(filter);

                int ret = fileopen.showDialog(pane, "Open");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    SwingUtilities.getWindowAncestor(BrowsButton.this).dispose();
                    File file = fileopen.getSelectedFile();
                    String[] layers = getFileLayers(file.getPath());
                    openLayerWindow(layers);
                }

            }
        });
    }