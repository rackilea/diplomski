private static void createAndShowGui() {
  ShowGraph showGraphPanel = new ShowGraph(MAX_POINTS);
  TimerListener timerListener = new TimerListener(MAX_POINTS, showGraphPanel);

  JFrame frame = new JFrame("TestShowGraph");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().add(showGraphPanel);
  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);

  // Timer now made a final variable so it can be referred to
  final Timer timer = new Timer(TIMER_DELAY, timerListener);
  timer.start();

  frame.addWindowListener(new WindowAdapter() {

     @Override
     public void windowOpened(WindowEvent arg0) {
        timer.start();
     }

     @Override
     public void windowIconified(WindowEvent arg0) {
        timer.stop();
     }

     @Override
     public void windowDeiconified(WindowEvent arg0) {
        timer.start();
     }

     @Override
     public void windowActivated(WindowEvent arg0) {
        timer.start();
     }
  });
}