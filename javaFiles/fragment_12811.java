import java.awt.EventQueue;
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WaitForSwingWorker {

    public static void main(String[] args) {
        new WaitForSwingWorker();
    }

    public WaitForSwingWorker() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                ConnectionListener callback = new ConnectionListener() {

                    @Override
                    public void connectionEstablished() {
                        // Continue running the app
                    }

                    @Override
                    public void connectionFailed() {
                        // Show error message :(
                    }
                };

                new ConnectionWorker(callback).execute();

                // Execution will continue here...

            }
        });
    }

    public interface ConnectionListener {
        public void connectionEstablished();
        // If possible, you should provide a message as to why...
        public void connectionFailed();
    }

    public class ConnectionWorker extends SwingWorker<Void, String> {

        private ConnectionListener callBack;

        public ConnectionWorker(ConnectionListener listener) {
            callBack = listener;
        }

        @Override
        protected void process(List<String> chunks) {
            // Back in the EDT...
            String msg = chunks.get(chunks.size() - 1);
            if (msg.equals("WAITING")) {
                // Show waiting for connection message...
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            // Within our own thread
            // Establish connection...
            if (!isConnected) {
                publish("WAITING");
                // Wait for incoming connection, this can block...
            }
            return null;
        }

        @Override
        protected void done() {
            // Back in the EDT
            if (isConnected) {
                // Show failed to connect message?
                callBack.connectionEstablished();
            } else {
                callBack.connectionFailed();
            }
        }

    }

}