import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class FlashingButton extends JPanel {
    private static final String START = "Start";
    private static final String STOP = "Stop";
    private static final int TIMER_DELAY = 200; // millisecond delay
    private static final int BI_WIDTH = 400;
    private Icon greenIcon;
    private Icon darkGreenIcon;
    private JButton greenButton = new JButton();
    private JButton startButton = new JButton(new StartAction(START));
    private Timer timer = new Timer(TIMER_DELAY, new TimerListener());

    public FlashingButton() {
        greenIcon = createMyIcon(Color.GREEN);
        darkGreenIcon = createMyIcon(Color.GREEN.darker());
        greenButton.setIcon(greenIcon);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        setLayout(new BorderLayout(20, 20));

        add(greenButton, BorderLayout.CENTER);
        add(startButton, BorderLayout.PAGE_END);
    }

    // Ignore this code. It simply is present to create image icons 
    // without having to use an actual image. This way you can run this code without an image
    private Icon createMyIcon(Color color) {
        BufferedImage img = new BufferedImage(BI_WIDTH, BI_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillOval(5, 5, BI_WIDTH - 10, BI_WIDTH - 10);
        g2.setStroke(new BasicStroke(10f));
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawOval(5, 5, BI_WIDTH - 10, BI_WIDTH - 10);
        g2.dispose();
        return new ImageIcon(img);
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // get icon from button
            Icon icon = greenButton.getIcon();

            // check if it's the green icon
            if (icon == greenIcon) {
                icon = darkGreenIcon;  // if so, make it the dark green icon
            } else {
                icon = greenIcon;  // if not, make it the green icon
            }
            greenButton.setIcon(icon);  // stuff it back into the button
        }
    }

    // this is my startButton's Action.
    // an Action is like an "ActionListener on steroids"
    private class StartAction extends AbstractAction {
        public StartAction(String name) {
            super(name);  // the text that appears in the button
            putValue(MNEMONIC_KEY, (int) name.charAt(0));  // the alt-key mnemonic
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer.isRunning()) {  // if the timer is currently running
                timer.stop();    // stop the Timer
                greenButton.setIcon(greenIcon);  // set the icon back to the defaut green icon
                putValue(NAME, START);  // change the button's text to "Start"
            } else {  // otherwise the Timer's not running
                timer.start();  // Start it
                putValue(NAME, STOP);  // change this button's text to "Stop"
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Flashing Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FlashingButton());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}