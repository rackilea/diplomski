import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class LayeredPaneEx extends JPanel {
    private JLayeredPane layeredPane;

    public LayeredPaneEx()    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 310));
        layeredPane.setLayout(null);

        //Canvas panel = new CustomCanvas();
        //panel.setSize(300, 400);
        //CustomPanel customPanel = new CustomPanel();
        //layeredPane.add(panel, new Integer(0));
        //layeredPane.add(customPanel, new Integer(1));
        layeredPane.add(new CustomPanel(300, 400, Color.YELLOW), new Integer(0));
        layeredPane.add(new CustomPanel(100, 100, Color.RED), new Integer(1));

        add(layeredPane);

        JButton paintBtn = new JButton("Paint All");
        paintBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(paintAllToImage(layeredPane));
                JLabel imageLabel = new JLabel(icon);
                add(imageLabel);
            }
        });
        add(paintBtn);

        JLabel paintLabel = new JLabel();
        paintLabel.setPreferredSize(new Dimension(300, 300));
    }

//    private class CustomCanvas extends Canvas  {
//        @Override
//        public void paint(Graphics g) {
//            g.setColor(Color.YELLOW);
//            g.fillRect(0, 0, getWidth(), getHeight());
//        }
//    }

    private class CustomPanel extends JPanel {
        public CustomPanel(int width, int height, Color backgroundColor) {
            setSize(width, height);
            setBackground(backgroundColor);
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("LayeredPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new LayeredPaneEx();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public BufferedImage paintAllToImage(Component component) {
        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        component.paintAll(image.getGraphics());

        return image;
    }
}