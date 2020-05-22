public class ClientThread extends Thread
    ...
    private final AtomicReference<PrintWriter> printWriterHolder;
    public ClientThread(Socket clientSocket, AtomicReference<PrintWriter> holder) {
        this.cs = clientSocket;
        this.printWriterHolder = holder;
    }

    @Override
    public void run() {
        String requestMsg = "";
        String responseMsg = "";
        do {
            requestMsg = read(cs);// read the message

            if (requestMsg.equalsIgnoreCase("SHUTDOWN")) {
                break;
            }
            responseMsg = process(requestMsg);
            out = printWriterHolder.get();
            out.write(responseMsg);
        } while (true);
    }
}