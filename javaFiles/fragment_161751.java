package example.stackoverflow;

import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SteppingSliderExample
{
    public static class SteppingSlider extends JSlider
    {
        private static final long serialVersionUID = -1195270044097152629L;
        private static final Integer[] VALUES = { 10, 30, 60, 100 };
        private static final Hashtable<Integer, JLabel> LABELS = new Hashtable<>();
        static
        {
            for(int i = 0; i < VALUES.length; ++i)
            {
                LABELS.put(i, new JLabel(VALUES[i].toString()));
            }
        }

        public SteppingSlider()
        {
            super(0, VALUES.length - 1, 0);
            setLabelTable(LABELS);      
            setPaintTicks(true);
            setPaintLabels(true);
            setSnapToTicks(true);
            setMajorTickSpacing(1);
        }

        public int getDomainValue()
        {
            return VALUES[getValue()];
        }
    }

    public static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SteppingSlider");
        frame.setSize(500, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final SteppingSlider steppingSlider = new SteppingSlider();
        final String labelPrefix = "Slider value: ";
        final JLabel output = new JLabel(labelPrefix + steppingSlider.getDomainValue());
        steppingSlider.addChangeListener(new ChangeListener()
        {           
            @Override
            public void stateChanged(ChangeEvent evt)
            {
                output.setText(labelPrefix + steppingSlider.getDomainValue());
            }
        });
        frame.getContentPane().setLayout(
                new BoxLayout(frame.getContentPane(), 
                        BoxLayout.Y_AXIS));     
        frame.getContentPane().add(steppingSlider);
        frame.getContentPane().add(output);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}