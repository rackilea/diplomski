class ReceiverThread extends Thread {

    private BufferedReader s;

    public ReceiverThread(Socket sock) throws IOException {
        s = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    @Override
    public void run() {
        while (true) 
            try {
                String message = s.readLine();
                // ...code to do whatever with message...
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}