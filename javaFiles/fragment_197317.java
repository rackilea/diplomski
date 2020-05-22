public class Tester {
  public static void main(String[] args) {
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
    JFrame frame = new JFrame("");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.setLayout(new BorderLayout());
    JFormattedTextField tf = new JFormattedTextField(df);
    tf.setFocusLostBehavior(JFormattedTextField.COMMIT);
    tf.setColumns(20);
    panel.add(tf);
    try {
      MaskFormatter dateMask = new MaskFormatter("##-##-####");
      dateMask.install(tf);
    } catch (ParseException ex) {
    }

    frame.add(new JButton(), BorderLayout.LINE_START);

    frame.add(panel, BorderLayout.LINE_END);
    frame.pack();
    frame.setVisible(true);
  }
}´