class AddDirectory implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        File[] theDir = null;
        theDir = selectDir();
        if(theDir != null) {
            for(File z : theDir) {
                String[] curRow = { z.toString(), "Waiting"};
                dlm.addRow(curRow);
            }
        }
        return;
    }   
    private File[] selectDir() {
        JFileChooser fileChooser = new JFileChooser(lastDir);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int showOpenDialog = fileChooser.showOpenDialog(null);
        if (showOpenDialog != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        File[] uploadDir = fileChooser.getSelectedFiles();
        lastDir = new File(uploadDir[uploadDir.length-1].getParent());
        return uploadDir;
    }
}