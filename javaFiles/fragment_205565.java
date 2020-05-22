//Frame maninFr = new Frame();
JTextField tf_1 = new JTextField();
//maninFr.add(tf_1);
//maninFr.show();

String[] alphabet = {"A","B"};
tf_1.setText(Arrays.toString(alphabet));
tf_1.addKeyListener(new KeyListener() {

 @Override
 public void keyTyped(KeyEvent e) {}

 @Override
 public void keyReleased(KeyEvent e) {
  String input = tf_1.getText();
  char pressed = e.getKeyChar();
  String newInput = input.replaceAll(Character.toString(pressed), "");
  System.out.println("pressed: " + pressed);
  System.out.println("newin : " + newInput);
  tf_1.setText(newInput);
 }

 @Override
 public void keyPressed(KeyEvent e) {}
});