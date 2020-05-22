public static void main(String args[]) {

    ActionListener timerListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            tick();
        }
    };

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Timer mainTimer = new Timer(500,timerListener);
            mainTimer.start();
        }
    });
}