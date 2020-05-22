public class Peaches extends JFrame {
  private JTextField item1;
  private String string;

  public Peaches() {
    super("the title");
    setLayout(new FlowLayout());
    item1 = new JTextField(10);
    add(item1);
    item1.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent event) {
        string = String.format(event.getActionCommand() );
        JOptionPane.showMessageDialog(null, string);
    }});
  }
}