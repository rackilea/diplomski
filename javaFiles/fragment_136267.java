public static void main(String[] args) {        
  JFrame testFrame = new JFrame();
  testFrame.setResizable(true);
  testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Timer testTimer = new Timer(6000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            testFrame.setResizable(false);
      Robot r;
      try {
        r = new Robot();
        r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK);
      } catch (AWTException ex) {
        ex.printStackTrace();
      }
    }

  });
  testFrame.setVisible(true);
  testTimer.start();
}