import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyScreen extends Screen {

    private int x = 0, y = 0;

    private BufferedImage image;

    public MyScreen(ScreenFactory screenFactory) {
        super(screenFactory);

        try {
            image = ImageIO.read(getClass().getResource("imagepath"));
        } catch (IOException e) {
            // TODO: handle exception
        }

    }

    @Override
    public void onCreate() {
        System.out.println("Creating!...");
    }

    @Override
    public void onUpdate() {
        if (getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_A))
            x -= 2;

        if (getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_D))
            x += 2;

        if (getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_W))
            y -= 2;

        if (getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_S))
            y += 2;

        if (y >= 720 - 72)
            y = 720 - 72;
        if (y <= 0)
            y = 0;
        if (x >= 1280 - 72)
            x = 1280 - 72;
        if (x <= 0)
            x = 0;

    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.fillRect(x, y, 72, 72);
        g2d.drawImage(image, x, y, null);
    }
}