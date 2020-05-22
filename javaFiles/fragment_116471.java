inputButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JFileChooser inputFile = new JFileChooser();
            inputFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (inputFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file1 = inputFile.getSelectedFile();
                String fullpathTemp = (String) file1.getAbsolutePath();
                fullpathTemp = fullPath;
            }
        }
    });