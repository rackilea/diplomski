import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatClient2 extends JPanel {
    private static final int VIS_ROW_CNT = 25;
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NO = 3000;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> jList = new JList<>(listModel);
    private SendAction sendAction = new SendAction("Send");
    private JButton sendButton = new JButton(sendAction);
    private JTextField textField = new JTextField(20);
    private PrintWriter out;

    public ChatClient2(Socket socket) throws IOException {
        out = new PrintWriter(socket.getOutputStream());
        SocketWorker worker = new SocketWorker(socket);
        worker.addPropertyChangeListener(new WorkerListener());
        worker.execute();

        jList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        jList.setVisibleRowCount(VIS_ROW_CNT);
        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textField.setAction(sendAction);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(textField);
        bottomPanel.add(sendButton);

        setLayout(new BorderLayout());
        add(scrollPane);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public void lineToGui(String line) {
        listModel.addElement(line);
    }

    private class SendAction extends AbstractAction {
        public SendAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            if (!text.trim().isEmpty()) {
                out.println(text);
                out.flush();
                lineToGui("Me: " + text);
            }
            textField.selectAll();
            textField.requestFocusInWindow();
        }
    }

    private class SocketWorker extends SwingWorker<Void, String> {
        private BufferedReader bin;

        public SocketWorker(Socket socket) throws IOException {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            bin = new BufferedReader(isr);
        } 

        @Override
        protected Void doInBackground() throws Exception {
            String line = null;
            while ((line = bin.readLine()) != null) {
                publish(line);
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String line : chunks) {
                lineToGui("Server: " + line);
            }
        }
    }

    private class WorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                @SuppressWarnings("rawtypes")
                SwingWorker worker = (SwingWorker) evt.getSource();
                try {
                    worker.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST_NAME, PORT_NO);
            SwingUtilities.invokeLater(() -> createAndShowGui(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createAndShowGui(Socket socket) {
        ChatClient2 mainPanel = null;
        try {
            mainPanel = new ChatClient2(socket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        JFrame frame = new JFrame("ChatClient2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}