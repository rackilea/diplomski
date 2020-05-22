public void actionPerformed(ActionEvent e) {
    File file = null;
    TextStatistics stat = null;

    if (e.getSource() == openButton) {
        int returnVal = fc.showOpenDialog(ProcessText.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            stat = new TextStatistics(file);
        }
    }
    if (e.getSource() == calculate) {

        log.append(stat.toString());
    }
}