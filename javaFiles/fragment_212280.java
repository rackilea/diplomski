JFileChooser fileChooser = new JFileChooser() {
    @Override
    public void approveSelection() {
        // test your condition here
        if (checkTheDir(getSelectedFile())
            super.approveSelection();
        else
            JOptionPane.showMessageDialog(null, "File GuiRap not found!", 
                "Controlla meglio", JOptionPane.WARNING_MESSAGE);                
    }
}