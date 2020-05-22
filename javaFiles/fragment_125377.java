TCPWait = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                WaitForConnection();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });