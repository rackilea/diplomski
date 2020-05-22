final String[] TEXT = {
        //message
        "Hello, World!",
        //title
        "Greeting"};//end TEXT

     ...

    /**
     * Create GUI and components on Event-Dispatch-Thread
     */
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
                JOptionPane.showMessageDialog(null, TEXT[0] 
                      + "\n is on EDT: " + SwingUtilities.isEventDispatchThread(), TEXT[1],
                        JOptionPane.INFORMATION_MESSAGE);
        }
    });