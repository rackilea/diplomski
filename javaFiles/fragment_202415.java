import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class AWT extends JFrame {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel players = new JPanel();
        players.add(new GameButton("Button 1"));
        players.add(new GameButton("Button 2"));
        players.add(new GameButton("Button 3"));
        players.setBackground(GameButton.color);

        JPanel game = new JPanel();
        game.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        game.setBackground(Color.green);
        game.setPreferredSize(new Dimension(600, 450));

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        frame.setContentPane(content);
        content.add(players, BorderLayout.NORTH);
        content.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private static class GameButton extends JButton {

        private static final Color color = Color.green.darker();
        private static final Font font = new Font("SanSerif", Font.BOLD, 20);
        private String name;

        public GameButton(String name) {
            super(name);
            this.setBackground(color);
            this.setFont(font);
        }
    }
}