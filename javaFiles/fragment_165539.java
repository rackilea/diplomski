public class StylePanel extends JPanel implements ActionListener {
 String[] fontArray = {"Arial", "Serif", "Courier", "Consolas"};
 JLabel   label;

 JRadioButton[] fontButtons = new JRadioButton[fontArray.length];
 ButtonGroup    fontGroup = new ButtonGroup();

 public StylePanel() {
  setLayout(new FlowLayout());
  label = new JLabel("Hello");
  add(label);
  for(int i = 0; i < fontButtons.length; i++) {
   fontButtons[i] = new JRadioButton();
   fontButtons[i].setText(fontArray[i]);
   fontButtons[i].addActionListener(this);
   fontGroup.add(fontButtons[i]);
   add(fontButtons[i]);
  }
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  label.setFont(new Font(
    ((JRadioButton)e.getSource()).getText(), Font.PLAIN, 15));
 } 

 public static void main(String[] args) {
  StylePanel panel = new StylePanel();
  JFrame frame = new JFrame();
  frame.getContentPane().add(panel);
  frame.setSize(400, 300);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
 }
}