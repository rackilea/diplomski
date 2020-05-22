JFileChooser jfc;
        jfc = new JFileChooser();     
        File f = new File(System.getProperty("user.dir"));
        jfc.setCurrentDirectory(f);
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showOpenDialog(parentFrame);
        File selFile = jfc.getSelectedFile();