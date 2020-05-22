private void startListening() {
    new Thread(new Runnable() {
        @Override
        public void run() {
            for(;;) {
                String msg = dis.readUTF();
                System.out.println("  ----- Recieved New Message -----\n" + msg);
                for (IMessageListener listener : listeners) {
                    try {
                        listener.onMessageRecieved(msg);
                    } catch (Exception e) {

                    }
                }
            }
        }
    }).start();
}