import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.w3c.dom.ls.LSInput;

public class UpdateListOnEvent {

    public static void main(String[] args) {
        new UpdateListOnEvent();
    }

    public UpdateListOnEvent() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ConnectionEvent {

        private Date date;

        public ConnectionEvent(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return date;
        }

    }

    public interface ConnectionListener {
        public void connectionEstablished(ConnectionEvent evt);
    }

    public class TestPane extends JPanel implements ConnectionListener {

        private JList list;
        private DefaultListModel<String> model;

        public TestPane() {
            setLayout(new BorderLayout());
            model = new DefaultListModel<>();
            list = new JList(model);
            add(new JScrollPane(list));
            EventPane eventPane = new EventPane();
            eventPane.addConnectionListener(this);
            add(eventPane, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

        @Override
        public void connectionEstablished(ConnectionEvent evt) {
            model.addElement(DateFormat.getDateTimeInstance().format(evt.getDate()));
        }
    }

    public class EventPane extends JPanel {

        private List<ConnectionListener> listeners;
        private JButton update;

        public EventPane() {
            listeners = new ArrayList<>(5);
            setLayout(new GridBagLayout());
            update = new JButton("Update");
            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    connectionEstablished(new Date());
                    fireConnectionEstablished(new Date());
                }
            });
            add(update);
        }

        public void addConnectionListener(ConnectionListener listener) {
            listeners.add(listener);
        }

        public void removeConnectionListener(ConnectionListener listener) {
            listeners.remove(listener);
        }

        protected ConnectionListener[] getConnectionListeners() {
            return listeners.toArray(new ConnectionListener[listeners.size()]);
        }

        protected void fireConnectionEstablished(Date date) {
            ConnectionListener[] listeners = getConnectionListeners();
            if (listeners != null && listeners.length > 0) {
                ConnectionEvent evt = new ConnectionEvent(date);
                for (ConnectionListener listener : listeners) {
                    listener.connectionEstablished(evt);
                }
            }
        }

    }
}