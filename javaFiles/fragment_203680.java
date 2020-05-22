import javax.swing.Timer;

class TimerExample {

   // only one timer per class (field)
   private Timer timer;

   TimerExample() {

    // initialize: counts 5 seconds, calls actionPerformed() and stops
    timer = new Timer(1000, new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent evt) {
        // handle timer invoked ...
        System.out.println("Now!");
      }      
    });
    timer.setRepeats(true);

    JButton startStopBtn = new JButton("Start / Stop");
    startStopBtn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!timer.isRunning()) {
                timer.start();
            } else {
                timer.stop();
            }
        }
    });
  }
 ...
}