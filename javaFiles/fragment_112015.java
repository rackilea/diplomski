package image;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/*import net.explorer.entities.Entity;
import net.explorer.entities.Player;
import net.explorer.render.ScreenRenderer;*/

public class Game extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    public int width, height;

    public BufferedImage screen;
    public int[] pixels;
    public ScreenRenderer screenRenderer;

    private Timer timer;

    /*public static ArrayList<Entity> entities;
    public Player player;*/

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();
        screenRenderer = new ScreenRenderer(screen);
        timer = new Timer(1, this);
        timer.start();
        /*entities = new ArrayList<Entity>();
        player = new Player();*/
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.render(g);
    }

    private void render(Graphics g) {
        screenRenderer.renderScreen();

        /*for (int i = 0; i < width * height; i++) {
            screenRenderer.pixels[i] = this.pixels[i];
        }*/

        g.drawImage(screen, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}