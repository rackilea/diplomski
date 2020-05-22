Thread messageThread;

public void chatWithServer() {
    messageThread = new Thread(new Runnable() {
        public void run() {
            String serverInput;
            while((serverInput = in.readLine()) != null) {
                //do code here
            }
        }
    };

    messageThread.start();
}