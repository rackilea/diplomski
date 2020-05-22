import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxStructAndJComponents {

    private JFrame frame;
    private JPanel intro;
    private JPanel name;

    public BoxStructAndJComponents() {
        frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = createUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createUI() {
        intro = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(100, 100);
            }
        };
        intro.setBackground(Color.red);
        //intro.setLabelFor(name);
        name = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(100, 100);
            }
        };
        name.setBackground(Color.blue);
        final JButton button = new JButton("Pick a new name...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        intro.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        name.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(intro);
        //panel.add(Box.createVerticalStrut(5));
        panel.add(Box.createHorizontalStrut(5));
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(150, 10)));
        panel.add(button);
        return panel;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BoxStructAndJComponents listDialogRunner = new BoxStructAndJComponents();
            }
        });
    }
}