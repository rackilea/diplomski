enter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            start_frame.dispose();

            new Thread() {
            @Override
            public void run() {
                try {
                    new Play();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        }
    });