public class RAMBIT7 implements ActionListener {

    private JFrame frame;
    private JTextArea textarea = new JTextArea();

    // ....

   private void initialize() {

        // .....

        // JTextArea textArea = new JTextArea();//JTextArea
        scrollPane.setViewportView(textArea);
        textArea.setLineWrap(true);