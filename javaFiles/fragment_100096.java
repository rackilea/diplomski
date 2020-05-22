//Imports
public class MainClass extends JFrame {
  private JPanel panel;
  private JLabel label;
  private JTextField text;
  private JButton SubmitButton;

  public MainClass(){
    super("Welcome");
    setSize(500, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel();
    add(panel);

    label = new JLabel("...");
    panel.add(label);

    text = new JTextField(20);
    panel.add(text);

    SubmitButton = new JButton("Analyze");
    panel.add(SubmitButton);
    SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ReceivedPath = text.getText(); 
                System.out.println(ReceivedPath);
            }
        });

   setVisible(true);
  }
}