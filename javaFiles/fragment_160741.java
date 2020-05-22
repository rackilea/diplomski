import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DrawTest extends JFrame {

    private JPanel contentPane;

    public DrawTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // instead pack() once components are added
        // setBounds(100, 100, 450, 300); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.CYAN);
        contentPane.add(leftPanel, BorderLayout.LINE_START);

        JLabel lblNewLabel = new JLabel("some stuff");
        leftPanel.add(lblNewLabel);

        JPanel drawPanel = new JPanel() {

            Dimension preferredSize = new Dimension(300, 100);

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.black);
                // 500? That's much deeper than the panel shows on-screen!
                //g.fillRect(25, 500, 100, 20);
                g.fillRect(25, 50, 100, 20);
            }

            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                if (d.width<50 || d.height<50) {
                    return preferredSize;
                } else {
                    System.out.println("d: " + d);
                    return d;
                }
            }
        };
        drawPanel.setBackground(Color.YELLOW);
        contentPane.add(drawPanel, BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DrawTest frame = new DrawTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}