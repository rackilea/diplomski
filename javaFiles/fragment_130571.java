import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFoo extends JPanel {
    private JSlider slider = new JSlider(0, 100, 50);
    private JLabel label = new JLabel("   ", SwingConstants.CENTER);

    public SliderFoo() {
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText(String.valueOf(slider.getValue()));
            }
        });

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Slider Value:"));
        topPanel.add(label);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(topPanel, BorderLayout.PAGE_START);
        add(slider);
    }

    private static void createAndShowGui() {
        SliderFoo mainPanel = new SliderFoo();

        JFrame frame = new JFrame("SliderFoo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}