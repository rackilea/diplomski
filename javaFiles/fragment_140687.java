import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainGUI extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI window = new MainGUI();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialize();
        pack();
    }

    private void initialize() {

        JPanel mainPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        mainPanel.setBackground(Color.RED);

        mainPanel.setLayout(new BorderLayout());

        JButton btn1 = new JButton();
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn1.setContentAreaFilled(false);
        btn1.setOpaque(false);
        btn1.setBorder(new EmptyBorder(0, 0, 0, 0));
        btn1.setText("This is a test");

        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBackground(Color.GREEN);
        rightButtonPanel.setLayout(new BoxLayout(rightButtonPanel, BoxLayout.Y_AXIS));
        rightButtonPanel.add(btn1);

        mainPanel.add(rightButtonPanel, BorderLayout.EAST);

        this.setContentPane(mainPanel);

    }

}