public class MyTextField extends JTextField {
private boolean substituteDot;

public MyTextField() {
  super();
  addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent event) {
      substituteDot = (event.getKeyCode() == KeyEvent.VK_DECIMAL);
    }
    @Override
    public void keyTyped(KeyEvent event) {
       if (substituteDot) {
         event.setKeyChar(',');
       }
     }
  });
 }
}