public class ThreadTest extends JPanel {
   private JButton button = new JButton(new ButtonAction());
   private MyRunnable[] runnables = { 
         new MyRunnable("thread 1", 1, 9, 50), 
         new MyRunnable("thread 2", 1000, 8999, 1) };
   private Thread[] threads = new Thread[runnables.length];

   public ThreadTest() {
      add(button);
      for (int i = 0; i < threads.length; i++) {
         threads[i] = new Thread(runnables[i]);
         threads[i].setName(runnables[i].getName());
         threads[i].start();
      }
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction() {
         super("Stop Threads");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         for (Thread thread : threads) {
            if (thread != null && thread.isAlive()) {
               thread.interrupt();
            }
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ThreadTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ThreadTest());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}