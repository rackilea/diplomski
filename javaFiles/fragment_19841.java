public class Shutdown implements ShutdownMBean{

    @Override
    public void doShutdown() {
        try {
            Socket clientSocket = new Socket("localhost", 8005);
            clientSocket.getOutputStream().write("SHUTDOWN".getBytes());
            clientSocket.getOutputStream().close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }

    @Override
    public String getName() {
        return "Shutdown JMX Hook";
    }

}