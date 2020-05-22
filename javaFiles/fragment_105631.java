import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Implementation {

    public static void main(String[] args) {
        World w = new World("Hej", "/resources/stackoverflow5.png", 1024, 768);
    }
}

class World extends JFrame {

    private static final long serialVersionUID = 1L;
    private SpritePanel spritePanel;
    private JPanel bottom;
    private int width;
    private int height;

    public World(String windowCaption, String bgPath, int width, int height) {
        super(windowCaption);

        spritePanel = new SpritePanel(bgPath);
        add(spritePanel, BorderLayout.CENTER);
        System.out.println(spritePanel);

        bottom = new JPanel();
        bottom.add(new JLabel("Hej"));
        add(bottom, BorderLayout.SOUTH);

        Dimension size = new Dimension(width, height);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
        setVisible(true);

        validate();
        repaint();
    }

    class SpritePanel extends JPanel {

        private static final long serialVersionUID = 1L;
        private ImageIcon background;
//private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

        public SpritePanel(String bgPath) {
            background = new ImageIcon(SpritePanel.class.getResource(bgPath));
            setLayout(null);
            Dimension size = new Dimension(background.getIconWidth(), background.getIconHeight());
            setPreferredSize(size);
            setMaximumSize(size);
            setMinimumSize(size);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background.getImage(), 0, 0, this);
            System.out.println("painted panel");
        }
    }
}