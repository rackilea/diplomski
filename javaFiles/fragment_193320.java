import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** @see https://stackoverflow.com/questions/6067898 */
public class SpinSlider extends JPanel {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("SpinSlider!");
                f.add(new SpinSlider());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    public SpinSlider() {
        this.setLayout(new FlowLayout());
        final JSpinner spinner = new JSpinner();
        final JSlider slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider) e.getSource();
                spinner.setValue(s.getValue());
            }
        });
        this.add(slider);
        spinner.setModel(new SpinnerNumberModel(50, 0, 100, 1));
        spinner.setEditor(new JSpinner.NumberEditor(spinner, "0'%'"));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner s = (JSpinner) e.getSource();
                slider.setValue((Integer) s.getValue());
            }
        });
        this.add(spinner);
    }
}