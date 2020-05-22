public class ObjectReferences {
  private final JLabel label = new JLabel("I am FOO"); // label 1

  public ObjectReferences() {
    JLabel label = new JLabel("I am BAR"); // label 2

    JButton button = new JButton("Click me");
    button.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        onclick();
      }
    });

    // will display "I am BAR"
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setLayout(new FlowLayout());
    frame.add(label); // label 2
    frame.add(button);
    frame.setVisible(true);
  }

  public void onclick() {
    // will display "I am FOO"
    JOptionPane.showMessageDialog(null, label.getText()); // label 1
  }

  public static void main(String[] args) {
    new ObjectReferences();
  }
}