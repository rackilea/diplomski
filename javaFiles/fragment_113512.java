import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class TestGraphics extends JFrame implements ActionListener
{
    JPanel utilBar = new JPanel();

    JButton hpUpBtn = new JButton("HP++");
    JButton hpDownBtn = new JButton("HP--");
    JButton mpUpBtn = new JButton("MP++");
    JButton mpDownBtn = new JButton("MP--");

    GraphicsPanel drawingArea = new GraphicsPanel();

    TestGraphics()
    {   
        setSize(600, 500);
        setLayout(new BorderLayout());

        add(utilBar, BorderLayout.NORTH);
        utilBar.setLayout(new GridLayout(1, 4));

        utilBar.add(hpUpBtn);
        utilBar.add(hpDownBtn);
        utilBar.add(mpUpBtn);
        utilBar.add(mpDownBtn);

        add(drawingArea, BorderLayout.CENTER);

        hpUpBtn.addActionListener(this);
        hpDownBtn.addActionListener(this);
        mpUpBtn.addActionListener(this);
        mpDownBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == hpUpBtn) {
            drawingArea.incHp();
        }
        else if (e.getSource() == hpDownBtn) {
            drawingArea.decHp();
        }
        else if (e.getSource() == mpUpBtn) {
            drawingArea.incMp();
        }
        else if (e.getSource() == mpDownBtn) {
            drawingArea.decMp();
        }

        System.out.println("Player HP: " + drawingArea.getHp() +
                " Player MP: " + drawingArea.getMp());

        drawingArea.revalidate();
        drawingArea.repaint();
    }

    public static void main(String[]agrs)
    {
        new TestGraphics();
    }
}

@SuppressWarnings("serial")
class GraphicsPanel extends JPanel {

    private static int baseX = 150;
    private static int baseY = 150;

    private static final int BAR_FULL = 287;
    private static final int BAR_EMPTY = 8;

    private BufferedImage image1 = null;
    private BufferedImage image2 = null;
    private BufferedImage image3 = null;

    private int playerHp = 100;
    private int playerMp = 100;

    public GraphicsPanel() {
        try {
            // All 3 images are the same as those posted in answer
            image1 = ImageIO.read(
                    getClass().getResourceAsStream("/Image1.png"));
            image2 = ImageIO.read(
                    getClass().getResourceAsStream("/Image2.png"));
            image3 = ImageIO.read(
                    getClass().getResourceAsStream("/Image3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void incHp() { playerHp += (playerHp < 100) ? 5 : 0; }
    public void decHp() { playerHp -= (playerHp > 0) ? 5 : 0; }
    public void incMp() { playerMp += (playerMp < 100) ? 5 : 0; }
    public void decMp() { playerMp -= (playerMp > 0) ? 5 : 0; }

    public int getHp() { return playerHp; }
    public int getMp() { return playerMp; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the graphics
        g.setClip(null);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);

        g.drawImage(image1, baseX, baseY, null);

        int hpPerc = (int) ((BAR_FULL - BAR_EMPTY) * (playerHp / 100.0));
        g.setClip(baseX + BAR_EMPTY + hpPerc, 0, 600, 500);
        g.drawImage(image2, baseX, baseY, null);
        g.setClip(null);

        int mpPerc = (int) ((BAR_FULL - BAR_EMPTY) * (playerMp / 100.0));
        g.setClip(baseX + BAR_EMPTY + mpPerc, 0, 600, 500);
        g.drawImage(image3, baseX, baseY + 78, null);
        g.setClip(null);
    }
}