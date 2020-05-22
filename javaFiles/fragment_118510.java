// import javax.swing.Timer;

final Color backup = componentX.getBackground();
componentX.setBackground(Color.YELLOW);
final Timer t = new Timer(700, new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    componentX.setBackground(backup);
  }
});
t.setRepeats(false);
t.start();