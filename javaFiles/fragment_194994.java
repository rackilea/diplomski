import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class SampleSwing {

    private JFrame frame;
    public static JTextField textField;
    public static boolean processing = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SampleSwing window = new SampleSwing();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SampleSwing() {
        initialize();
    }
    private Timer processTimer;

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        textField = new JTextField(25);
        frame.add(textField, gbc);

        processTimer = new Timer(500, new ActionListener() {
            private StringBuilder dots = new StringBuilder(3);
            @Override
            public void actionPerformed(ActionEvent e) {
                dots.append(".");
                if (dots.length() > 3) {
                    dots.delete(0, dots.length());
                }
                textField.setText("Processing" + dots.toString());
            }
        });

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!processing) {
                    processing = true;
                    processTimer.start();
                } else {
                    processTimer.stop();
                    processing = false;
                    textField.setText(null);
                }
            }
        });
        frame.add(btnNewButton, gbc);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}