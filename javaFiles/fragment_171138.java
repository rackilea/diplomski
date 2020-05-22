import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
public class Deploy extends JFrame {

    private int seconds;
    private SimpleDateFormat df;
    private JLabel lblTimer;
    private Timer timer;
    private  JButton startButton;

    public Deploy() {

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        lblTimer = new JLabel();
        lblTimer.setForeground(Color.WHITE);
        lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTimer.setPreferredSize(new Dimension(100,30));
        contentPane.add(lblTimer,BorderLayout.NORTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTimer();
                seconds++;
            }
        });

        JPanel buttonsPanel = new JPanel();
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);

        startButton = new JButton("Start");
        startButton.setBackground(Color.LIGHT_GRAY);
        startButton.setForeground(Color.BLUE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(timer.isRunning()) {
                    timer.stop();
                    startButton.setText("Start");
                }else {
                    timer.start();
                    startButton.setText("Stop");
                }
            }
        });

        startButton.setPreferredSize(new Dimension(100,30));
        buttonsPanel.add(startButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setForeground(Color.RED);
        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetTimer();
            }
        });
        resetButton.setPreferredSize(new Dimension(100,30));
        buttonsPanel.add(resetButton);

        df = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        resetTimer();
        pack();
        setVisible(true);
    }

    private void setTimer() {
        Date d = new Date(seconds * 1000L);
        String time = df.format(d);
        lblTimer.setText(time);
    }

    private void resetTimer() {

        if(timer.isRunning()) {
            timer.stop();
        }
        startButton.setText("Start");
        seconds = 0;
        setTimer();
    }

    public static void main(String[] args) {
        new Deploy();
    }
}