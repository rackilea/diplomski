public class MainWindow extends JFrame implements ActionListener, WindowListener
    {
     // Some code, like generating JFrame, JButtons and other stuff not affencting the task.

        final Thread th1 = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        mapp();                 

                    }
                }); 
        public void actionPerformed(ActionEvent e)
        {       
        boolean isStarted = false;

    // Start Button
    if (e.getSource() == this.buttonStart)
    {
        if(!isStarted)
        {
        System.out.println("start");
        labelSuccess.setText("Mapping started!");
        this.setEnabled(true);
        th1.start();
        isStarted = false;
        }
    }
    // Stop Button
    if (e.getSource() == this.buttonStop)
        {
        labelSuccess.setText("Mapping stopped!");
        th1.stop();
        }
  }