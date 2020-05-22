public class ClientServiceThread extends Thread  {
private PrintWriter outWr;

ClientServiceThread(Socket s, int clientID, Auction a) {
        try {
            PrintWriter outWr = new PrintWriter(new OutputStreamWriter(