@Override
public void actionPerformed(ActionEvent e) {
   JMenuItem source = (JMenuItem) e.getSource();
   if (source == itmOpen) {
      final JDialog message = new Message();
      new Thread( new Runnable() {
         @Override
         public void run() {
            try {
               TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
               // Do nothing with it
            }
            WindowEvent windowClosing = new WindowEvent(message, WindowEvent.WINDOW_CLOSING);
            message.dispatchEvent(windowClosing);
         }
      }).start();
   }
}