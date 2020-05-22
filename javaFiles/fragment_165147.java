import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EmergencyAlertNotifier implements Runnable, ActionListener {

    private JDialog dialog = new JDialog();
    private int number = 0;
    private JLabel message;
    private JButton yes, no;
    private String messageStr;
    private boolean runProcess = true;

    public EmergencyAlertNotifier() {
        dialog.setLayout(new GridLayout());
        //The JLabel which will display the number of seconds left
        //before alerting emergency services
        message = new JLabel();
        messageStr = "number";
        yes = new JButton("OK");
        yes.addActionListener(this);
        no = new JButton("Cancel");
        no.addActionListener(this);
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(yes);
        btnPanel.add(no);
        dialog.add(message, "Center");
        dialog.add(btnPanel, "South");
        dialog.setTitle("Ready To Notify Emergency Fire Services");
        dialog.pack();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (runProcess) {
            for (int i = 10; i > 0; i--) {
                message.setText(messageStr + " " + i + " Sec.");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            runProcess = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yes) {
        } else {
            dialog.dispose();
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmergencyAlertNotifier ean = new EmergencyAlertNotifier();
            }
        });
    }
}