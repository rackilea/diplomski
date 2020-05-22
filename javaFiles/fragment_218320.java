public class NoBug extends JPanel {
    private JTextArea textArea = new JTextArea(); // unique text area

    private void build()  {
        this.add(new JScrollPane(this.textArea));
    }

    public void actionPerformed(ActionEvent e) {
        this.textArea.setText("foo"); // here, we modify the unique text area, which has been added to the GUI in the build() method        }
}