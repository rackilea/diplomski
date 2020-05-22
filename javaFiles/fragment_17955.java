private static javax.swing.Timer t; 
    public static void main(String[] args) {
        t = null;
        t = new Timer(2000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Printing statement after every 2 seconds");
                //t.stop(); // if you want only one print uncomment this line
            }
        });

        java.util.Timer tt = new java.util.Timer(false);
        tt.schedule(new TimerTask() {
            @Override
            public void run() {
                t.start();
            }
        }, 0);
    }