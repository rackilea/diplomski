new Thread(new Runnable() {
    public void run() {
        int counter = 0;

        while (counter < 10)  {
            lblDisplay.setText("Completed " + Integer.toString(counter));
            try {
                Thread.sleep(1000);
                final int finalCounter = counter;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblDisplay.setText("Completed " + finalCounter);
                    }
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(Increment.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }    
    }
}).start();