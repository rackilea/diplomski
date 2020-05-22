b3.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {

        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(fc);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getName();
            l6.setText(fileName);
        }
    }
});