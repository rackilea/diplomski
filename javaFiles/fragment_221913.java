public static void main (String[] args) {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "CSV files", "csv");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(chooser);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();
        System.out.println(file.getAbsolutePath());
    }
}