public class Main2 {
  public static final int TIMER_DELAY = 1000;
  private int number = 0;

  public void someMethod() {
    numberLabel.setText(String.valueOf(number));
    new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        number++;
        numberLabel.setText(String.valueOf(number));
      }
    }).start();
  }
}