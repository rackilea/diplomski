public class Solution extends JFrame {
    private static final String FILE_NAME_1 = "Selected SOLL:";
    private File file;
    private void setNewButton(Container contentPane, final String fileName, String format) {
        contentPane.add(Box.createVerticalStrut(5));
        final Label label = new Label("Select " + fileName + " in ." + format +" format");
        contentPane.add(label);
        contentPane.add(Box.createVerticalStrut(10));
        Button selection = new Button("Select " + fileName);
        contentPane.add(selection);
        selection.addActionListener(new FileSelectionListener("Only " + format + " is allowed", format) {
            @Override
            protected void setSelection(File selectedFile) {
                setFile(selectedFile);  // call file setter here
                label.setText("Selected" + fileName + selectedFile.getAbsolutePath());
            }
        });
    }

    // define a setter for your File member
    private void setFile(File file) {
        this.file = file;
    }

    public void uploadFiles() {
        Container contentPane = this.getContentPane();
        setNewButton(contentPane, FILE_NAME_1, "xls");
    }
}