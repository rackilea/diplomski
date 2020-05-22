btnStartServer.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            new Thread(new Runnable() {
                public void run() { 
                    ServerMain.main(new String[0]);
                }
             }).start();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
});