import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEffect extends JFrame
{
    private JSlider slider;
    private int count = 0;
    private ChangeListener changeListener = new ChangeListener()
    {
        public void stateChanged(ChangeEvent ce)
        {
            System.out.println(count++);
        }
    };

    private void createAndDisplayGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);

        slider = new JSlider(0, 10, 5);
        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(changeListener);

        contentPane.add(slider);

        getContentPane().add(contentPane);
        pack();
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new SliderChangeEffect().createAndDisplayGUI();
            }
        });
    }
}