JTextField textField = new JTextField();
JLabel keylabel = new JLabel("Press any key");
private int tries = 10;

@Override
public void keyPressed(KeyEvent e) {
     keylabel.setText("You pressed " + (e.getKeyCode() == KeyEvent.VK_C ? "correct" : "wrong"));
     if (--tries <= 0) {
         keylabel.setText("No tries left");
         textField.setEnabled(false);
     }
}