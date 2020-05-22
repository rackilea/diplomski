import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private final String title = "title here";

    public Test() {
        EventQueue.invokeLater(() -> {
            JFrame main = new JFrame(title);
            main.add(new MainPane());
            main.pack();
            main.setLocationRelativeTo(null);
            main.setVisible(true);
        });
    }

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public static class MainPane extends JPanel {

        private Image backgroundIMG;

        public MainPane() {
            setLayout(new BorderLayout());

            setBackground(Color.GRAY);

            add(new Board());

            String titleFont = "Ravie";
            int titleSize = 47;
            JLabel title = new JLabel("text");
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setFont(new Font(titleFont, Font.BOLD, titleSize));
            title.setForeground(new Color(251, 102, 8));
            add(title, BorderLayout.NORTH);
        }
    }

    public static class Board extends JPanel {

        public Board() {
            initBoard();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GAME_WIDTH, GAME_HEIGHT);
        }

        private void initBoard() {
            setBackground(Color.GRAY);
        }
    }

}