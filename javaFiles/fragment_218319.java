public class Bug extends JPanel {
    private JTextArea textArea = new JTextArea(); // first text area

    private void build()  {
        JTextArea textArea = new JTextArea(); // second text area. Inaccessible outside of this method
        this.add(new JScrollPane(textArea));
    }

    public void actionPerformed(ActionEvent e) {
        this.textArea.setText("foo"); // here, we modify the first text area, but it hasn't been added to the GUI, so it's invisible
    }
}