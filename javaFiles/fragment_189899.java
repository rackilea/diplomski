import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class SimpleBackgroundTest extends Applet
{
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1200;

    public static void main(String[] args) throws IOException
    {
        System.setProperty("sun.awt.noerasebackground", "true");
        Frame frame = new MainFrame(new SimpleBackgroundTest(), WIDTH, HEIGHT);
    }

    public SimpleBackgroundTest()
    {
        setLayout(new BorderLayout());
        Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        add("Center", c);

        BranchGroup group = new BranchGroup();
        group.addChild(createSomeCube());

        BufferedImage stars = null;
        BufferedImage glow = null;
        try
        {
            stars = ImageIO.read(new File("bg-stars.png"));
            glow = ImageIO.read(new File("bg-glow.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BufferedImage tiled = createTiled(stars, WIDTH, HEIGHT);
        BufferedImage overlay = createOverlay(tiled, glow);

        Background background = createBackground(overlay);
        group.addChild(background);

        SimpleUniverse universe = new SimpleUniverse(c);
        universe.addBranchGraph(group);
        universe.getViewingPlatform().setNominalViewingTransform();
    }

    private static BufferedImage createTiled(
        BufferedImage image, int targetSizeX, int targetSizeY)
    {
        BufferedImage result = new BufferedImage(
            targetSizeX, targetSizeY,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        for (int x = 0; x < targetSizeX; x += image.getWidth())
        {
            for (int y = 0; y < targetSizeY; y += image.getHeight())
            {
                g.drawImage(image, x, y, null);
            }
        }
        g.dispose();
        return result;
    }

    private static BufferedImage createOverlay(
        BufferedImage image, BufferedImage overlay)
    {
        BufferedImage result = new BufferedImage(
            image.getWidth(), image.getHeight(), 
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(overlay, 0, 0, image.getWidth(), image.getHeight(), null);
        g.dispose();
        return result;
    }

    private static Background createBackground(BufferedImage image)
    {
        TextureLoader textureLoader = new TextureLoader(image);
        ImageComponent2D imageComponent = textureLoader.getImage();
        Background background = new Background();
        background.setImage(imageComponent);
        background.setImageScaleMode(Background.SCALE_FIT_ALL);
        background.setCapability(Background.ALLOW_IMAGE_WRITE);
        background.setApplicationBounds(new BoundingSphere());
        return background;
    }

    private TransformGroup createSomeCube()
    {
        ColorCube cube = new ColorCube(0.5f);
        Transform3D t = new Transform3D();
        t.rotY(0.2);
        t.setScale(0.1);
        TransformGroup tg = new TransformGroup();
        tg.setTransform(t);
        tg.removeAllChildren();
        tg.addChild(cube);
        return tg;
    }
}