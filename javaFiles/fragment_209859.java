import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class LayoutTest {

    public static void main(String[] args) {
        new LayoutTest();
    }

    public LayoutTest() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new ScoreCardsPane(), gbc);

            gbc.gridx = 1;
            add(new TimePane(), gbc);
        }

    }

    public class TimePane extends JPanel {

        public TimePane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(4, 4, 4, 4);

            add(createScoreCard(), gbc);
            gbc.gridx++;
            add(createScoreCard(), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            add(createScoreCard(), gbc);
            gbc.gridx++;
            add(createScoreCard(), gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridwidth = 3;
            add(new TimeCard(), gbc);
        }

    }

    public class TimeCard extends JPanel {

        public TimeCard() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("TEMPO"), gbc);
            JLabel time = new JLabel("10:00");
            time.setBorder(new LineBorder(Color.BLACK));
            add(time, gbc);
        }

    }

    public class ScoreCardsPane extends JPanel {

        public ScoreCardsPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;

            JLabel topLabel = new JLabel("PONTOS");
            add(topLabel, gbc);
            JLabel bottomLabel = new JLabel("PONTOS");
            gbc.gridy = 3;
            add(bottomLabel, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridy = 1;
            gbc.gridwidth = 1;

            add(createScoreCard(), gbc);
            gbc.gridx++;
            add(createScoreCard(), gbc);
            gbc.gridx++;
            add(createScoreCard(), gbc);

            gbc.gridy++;
            gbc.gridx = 0;

            add(createScoreCard(), gbc);
            gbc.gridx++;
            add(createScoreCard(), gbc);
            gbc.gridx++;
            add(createScoreCard(), gbc);

        }

    }

    protected static JPanel createScoreCard() {

        JPanel card = new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }

        };
        card.setBackground(Color.RED);

        return card;

    }

}