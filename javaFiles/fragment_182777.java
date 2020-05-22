class Bute implements ActionListener, Runnable {
    //let class implement Runnable interface
    Thread t;   // define 2nd thread

    public void actionPerformed(ActionEvent e) {

        t = new Thread(this);   //start a new thread
        t.start();
    }

    @Override               //override our thread's run() method to do what we want 
    public void run() {     //this is after some java-internal init stuff called by start()
        //b.setEnabled(false);
        for (int i = 0; i < 150; i++) {
            x++;
            y++;
            m.repaint();
            try {
                Thread.sleep(50);   //let the 2nd thread sleep
            } catch (InterruptedException iEx) {
                iEx.printStackTrace();  
            }
        }
        //b.setEnabled(true);
    }

}