import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
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
                frame.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(4, 4, 4, 4);
                gbc.gridx = 0;
                gbc.weightx = 1;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                frame.add(createPane(Color.RED), gbc);
                gbc.gridy++;
                frame.add(createPane(Color.GREEN), gbc);
                gbc.gridy++;
                frame.add(createPane(Color.BLUE), gbc);
                gbc.gridy++;
                frame.add(createPane(Color.CYAN), gbc);
                gbc.gridy++;
                frame.add(createPane(Color.MAGENTA), gbc);
                gbc.gridy++;
                frame.add(createPane(Color.ORANGE), gbc);
                gbc.gridy++;
                frame.add(createPane(Color.PINK), gbc);

                gbc.gridx++;
                gbc.weightx = 0;
                gbc.gridy = 0;
                gbc.weighty = 1;
                gbc.gridheight = GridBagConstraints.REMAINDER;
                gbc.fill = GridBagConstraints.VERTICAL;
                frame.add(createPane(Color.YELLOW), gbc);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public JPanel createPane(Color color) {
        JPanel pane = new JPanel(){ 

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(50, 50);
            }

        };
        pane.setBackground(color);
        return pane;
    }

}