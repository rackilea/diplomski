import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ContentPane());
                frame.setResizable(false);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ContentPane extends JPanel {

        private static final long serialVersionUID = 1L;

        private GameView gameView;
        private PlayView playView;
        private TimeView timeView;

        public ContentPane() {
            this.setLayout(new BorderLayout());
            setGameView(new GameView(), new PlayView(), new TimeView());
        }

        public void setGameView(GameView gameView, PlayView playView, TimeView timeView) {
            this.gameView = gameView;
            this.playView = playView;
            this.timeView = timeView;

            JPanel subPanel = new JPanel();
            subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
            subPanel.add(gameView);
            subPanel.add(timeView);

            this.add(playView, BorderLayout.CENTER);
            this.add(subPanel, BorderLayout.WEST);
        }

    }

    public class GameView extends JPanel {

        private static final long serialVersionUID = 1L;

        public GameView() {
            this.setBackground(Color.decode("#2A2828"));
            this.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.GRAY));
            this.setPreferredSize(new Dimension(200, 300));
        }

    }

    public class TimeView extends JPanel {

        private static final long serialVersionUID = 1L;

        public TimeView() {
            this.setBackground(Color.decode("#2A2828"));
            this.setPreferredSize(new Dimension(200, 500));
        }
    }

    public class PlayView extends JPanel {

        private static final long serialVersionUID = 1L;

        public PlayView() {
            this.setBackground(Color.decode("#1F1F40"));
            this.setPreferredSize(new Dimension(1100, 800));
        }

    }
}