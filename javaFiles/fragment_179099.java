import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

                JPanel greenPane = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(275, 300);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.GREEN;
                    }

                };
                JPanel redPane = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(300, 600);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.RED;
                    }

                };

                JPanel left = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.weighty = 0.25;
                gbc.fill = GridBagConstraints.BOTH;

                left.add(greenPane, gbc);
                gbc.gridy++;
                gbc.weighty = 0.75;
                left.add(redPane, gbc);

                JPanel yellowPane = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 50);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.YELLOW;
                    }

                };

                JPanel grayPane = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 600);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.GRAY;
                    }

                };

                JPanel center = new JPanel(new GridBagLayout());
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1;
                gbc.weighty = 1;
                center.add(grayPane, gbc);

                gbc.gridy++;
                gbc.weighty = 0;
                center.add(yellowPane, gbc);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(left, BorderLayout.WEST);
                frame.add(center);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}