import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockWindow {
    private JFrame window;
    private JLabel clockLabel;
    public final static int ONE_SECOND = 1000;
    private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
    public ClockWindow(){
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clockLabel = new JLabel();
        clockLabel.setFont(new Font(clockLabel.getFont().getName(), Font.PLAIN, 80));
        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(clockLabel,BorderLayout.CENTER);
    }

    public void show(){

        Timer timer = new Timer(ONE_SECOND, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clockLabel.setText(clockFormat.format(new Date()));
                clockLabel.repaint();
            }
        });
        clockLabel.setText(clockFormat.format(new Date()));
        timer.start();
        window.pack();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClockWindow app = new ClockWindow();
                app.show();
            }
        });
    }
}