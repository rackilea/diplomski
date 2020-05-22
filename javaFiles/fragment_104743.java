import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IA extends JFrame {

    private final JPanel contentPane;
    //   private final JPanel home;  // REMOVED
    //   private JPanel clients;  // REMOVED

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IA frame = new IA();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public IA() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        final JPanel home = new JPanel();
        contentPane.add(home, "name_714429679706141");
        home.setLayout(null);

        final JPanel clients = new JPanel();  // MOVED UP
        contentPane.add(clients, "name_714431450350356");  // MOVED UP
        clients.setLayout(null);  // MOVED UP

        JButton btnClients = new JButton("Clients");
        btnClients.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                home.setVisible(false);
                clients.setVisible(true);
            }
        });
        btnClients.setBounds(160, 108, 89, 23);
        home.add(btnClients);

        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                clients.setVisible(false);
                home.setVisible(true);
            }
        });
        btnHome.setBounds(169, 107, 89, 23);
        clients.add(btnHome);
    }

}