import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Clock extends JFrame {

    JLabel year, month, date, hour, minute, second;

    public Clock(Calendar cal) {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cal.setTime(new Date());
                updateTime(cal);
            }
        };

        year = new JLabel();
        month = new JLabel();
        date = new JLabel();
        hour = new JLabel();
        minute = new JLabel();
        second = new JLabel();

        setLayout(new FlowLayout());

        add(year);
        add(month);
        add(date);
        add(hour);
        add(minute);
        add(second);

        updateTime(cal);

        javax.swing.Timer timer = new javax.swing.Timer(500, listener);
        timer.setInitialDelay(0);
        timer.start();
    }

    protected void updateTime(Calendar cal) {
        year.setText("year: " + cal.get(Calendar.YEAR));
        month.setText("month: " + cal.get(Calendar.MONTH));
        date.setText("date: " + cal.get(Calendar.DATE));
        hour.setText("hour: " + cal.get(Calendar.HOUR));
        minute.setText("minute: " + cal.get(Calendar.MINUTE));
        second.setText("second: " + cal.get(Calendar.SECOND));
    }

    public static void main(String args[]) {
        new Clock();
    }

    public Clock() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Calendar current = Calendar.getInstance();
                Clock frame = new Clock(current);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}