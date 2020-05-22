public class ActionListenerDemo2 {
  private final JFrame frame = new JFrame();
  private Object thingIWantToUse = "Hello";

  public ActionListenerDemo2() {
    JButton button = new JButton("Click");
    button.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        thingIWantToUse = "Goodbye";
        System.out.println(thingIWantToUse);
      }
    });
    frame.setLayout(new FlowLayout());
    frame.add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new ActionListenerDemo2().frame.setVisible(true);
  }
}