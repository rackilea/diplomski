import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class RollDice extends JPanel {
    // nice public domain dice face images. All 6 images in one "sprite sheet" image.
    private static final String IMG_PATH = "https://upload.wikimedia.org/"
            + "wikipedia/commons/4/4c/Dice.png";
    private static final int TIMER_DELAY = 200;
    private List<Icon> diceIcons = new ArrayList<>();  // list to hold dice face image icons
    private JLabel diceLabel = new JLabel(); // jlabel to display images
    private Timer diceTimer; // swing timer

    public RollDice(BufferedImage img) {
        // subdivide the sprite sheet into individual images
        // use them to create ImageIcons
        // and add them to my diceIcons ArrayList<Icon>.
        double imgW = img.getWidth() / 3.0;
        double imgH = img.getHeight() / 2.0;
        for (int row = 0; row < 2; row++) {
            int y = (int) (row * imgH); 
            for (int col = 0; col < 3; col++) {
                int x = (int) (col * imgW);
                BufferedImage subImg = img.getSubimage(x, y, (int)imgW, (int)imgH);
                diceIcons.add(new ImageIcon(subImg));
            }
        }

        // panel to hold roll dice button
        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.add(new JButton(new RollDiceAction("Roll Dice")));

        // set the JLabel's icon to the first one in the collection
        diceLabel.setIcon(diceIcons.get(0));

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(diceLabel);
        add(btnPanel, BorderLayout.PAGE_END);

    }

    public void rollDice() {
        // if the timer's already running, exit this method
        if (diceTimer != null && diceTimer.isRunning()) {
            return;
        }

        // else create a new Timer and start it
        diceTimer = new Timer(TIMER_DELAY, new TimerListener());
        diceTimer.start();
    }

    // ActionListener for the Swing Timer
    private class TimerListener implements ActionListener {
        private int count = 0;  // count how many times dice changes face
        private final int maxCount = 20;

        @Override
        public void actionPerformed(ActionEvent e) {
            // once there are max count changes, stop the timer
            if (count >= maxCount) {
                ((Timer) e.getSource()).stop();
            }

            // get a random index from 0 to 5
            int randomIndex = (int) (Math.random() * diceIcons.size());
            // show that random number's dice face
            diceLabel.setIcon(diceIcons.get(randomIndex));
            count++;  // increment the count
        }
    }

    // ActionListener for our button
    private class RollDiceAction extends AbstractAction {
        public RollDiceAction(String name) {
            super(name); // text to show in the button
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            rollDice();  // simply call the roll dice method
        }
    }

    private static void createAndShowGui(BufferedImage img) {
        RollDice mainPanel = new RollDice(img);

        JFrame frame = new JFrame("RollDice");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            URL imgUrl = new URL(IMG_PATH);
            final BufferedImage img = ImageIO.read(imgUrl);
            SwingUtilities.invokeLater(() -> {
                createAndShowGui(img);
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}