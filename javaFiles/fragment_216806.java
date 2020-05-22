import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Main extends JFrame
{
    private JSlider slider;
    private JSpinner spinner;
    private int min, max;

    public Main()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        initializeComponents();
        setVisible(true);
    }

    public void initializeComponents()
    {
        min = 0;
        max = 100;
        slider = new JSlider(JSlider.HORIZONTAL, min, max, min);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        spinner = new JSpinner(new SpinnerNumberModel(min, min, max, 1));

        slider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                spinner.setValue(slider.getValue());
            }
        });

        spinner.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                slider.setValue((int) spinner.getValue());
            }
        });

        add(slider, BorderLayout.NORTH);
        add(spinner, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {

                try
                {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                }
                catch (ClassNotFoundException | InstantiationException
                        | IllegalAccessException
                        | UnsupportedLookAndFeelException e)
                {
                }
                new Main();
            }
        });
    }
}