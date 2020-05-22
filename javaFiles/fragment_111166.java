package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TickerTest {
    private static final BigDecimal ONE_THOUSAND = BigDecimal.TEN.pow(3);
    private static final BigDecimal CURR_HZ = BigDecimal.TEN.pow(4).multiply(new BigDecimal(2));
    private static final JLabel label = new JLabel("<not running>");

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerTuple timerTuple = getTimerTuple();
                BigDecimal ratio = timerTuple.getTimerInterval().divide(timerTuple.getShakeIncrement(), 8, RoundingMode.DOWN);
                label.setText(ratio.toString());
            }
        };

        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);

        Timer timer = new Timer(1000, listener);
        timer.start();
    }

    private static TimerTuple getTimerTuple () {
        BigDecimal timerInterval = ONE_THOUSAND;
        BigDecimal shakeIncrement = getCurrentHz();

        if (shakeIncrement.equals(BigDecimal.ZERO)) {
            return new TimerTuple(BigDecimal.ZERO, BigDecimal.ONE);
        }

        if (shakeIncrement.compareTo(timerInterval) < 0) {
            timerInterval = timerInterval.divide(shakeIncrement);
            return new TimerTuple(BigDecimal.ONE, timerInterval);
        } 
        else {
            shakeIncrement = shakeIncrement.divide(timerInterval, 8, RoundingMode.DOWN);
            return new TimerTuple (shakeIncrement, BigDecimal.ONE);
        }
    }

    private static BigDecimal getCurrentHz() {
        return CURR_HZ;
    }
}