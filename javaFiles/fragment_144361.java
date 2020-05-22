public class ObjectReferences {
  private final JLabel label = new JLabel("I am FOO");

  public ObjectReferences() {
    JButton button = new JButton("Click me");
    button.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        onclick();
      }
    });

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setLayout(new FlowLayout());
    frame.add(label);
    frame.add(button);
    frame.setVisible(true);
  }

  public void onclick() {
    JOptionPane.showMessageDialog(null, label.getText());
  }

  public static void main(String[] args) {
    new ObjectReferences();
  }
}