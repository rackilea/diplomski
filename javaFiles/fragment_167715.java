import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class CircleImages {

    private int score = 0;
    private JTextField scoreField = new JTextField(10);

    public CircleImages() {
        scoreField.setEditable(false);

        final ImageIcon[] icons = createImageIcons();
        final JPanel iconPanel = createPanel(icons, 8);

        JPanel bottomLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        bottomLeftPanel.add(new JLabel("Score: "));
        bottomLeftPanel.add(scoreField);

        JPanel bottomRightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JButton newGame = new JButton("New Game");
        bottomRightPanel.add(newGame);
        JButton quit = new JButton("Quit");
        bottomRightPanel.add(quit);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(bottomRightPanel);

        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reset(iconPanel, icons);
                score = 0;
                scoreField.setText(String.valueOf(score));
            }
        });

        JFrame frame = new JFrame();
        frame.add(iconPanel);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void reset(JPanel panel, ImageIcon[] icons) {
        Component[] comps = panel.getComponents();
        Random random = new Random();
        for(Component c : comps) {
            if (c instanceof JLabel) {
                JLabel button = (JLabel)c;
                int index = random.nextInt(icons.length);
                button.setIcon(icons[index]);
            }
        }
    }

    private JPanel createPanel(ImageIcon[] icons, int gridSize) {
        Random random = new Random();
        JPanel panel = new JPanel(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize * gridSize; i++) {
            int index = random.nextInt(icons.length);
            JLabel label = new JLabel(icons[index]);
            label.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    score += 1;
                    scoreField.setText(String.valueOf(score));
                }
            });
            label.setBorder(new LineBorder(Color.GRAY, 2));
            panel.add(label);
        }
        return panel;
    }

    private ImageIcon[] createImageIcons() {
        String[] files = {"blackcircle.png",
            "bluecircle.png",
            "greencircle.png",
            "greycircle.png",
            "orangecircle.png",
            "redcircle.png",
            "yellowcircle.png"
        };
        ImageIcon[] icons = new ImageIcon[files.length];
        for (int i = 0; i < files.length; i++) {
            icons[i] = new ImageIcon(getClass().getResource("/circles/" + files[i]));
        }
        return icons;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CircleImages();
            }
        });
    }
}