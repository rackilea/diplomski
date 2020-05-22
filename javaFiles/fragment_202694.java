import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private int currentIndex;

    public Main() throws IOException {
        JFrame frame = new JFrame("FRAME");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        List<Cursor> cursors = new ArrayList<>();
        List<BufferedImage> frames = getFrames("GWigb.gif");
        for (BufferedImage image : frames) {
            cursors.add(Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "cursor image"));
        }

        Timer timer = new Timer(50, (actionEvent) -> {
            panel.setCursor(cursors.get(currentIndex++));
            if (currentIndex >= cursors.size())
                currentIndex = 0;
        });
        timer.start();

        panel.setPreferredSize(new Dimension(1600, 900));
        frame.setVisible(true);
        frame.pack();
    }

    public List<BufferedImage> getFrames(String gif) throws IOException {
        List<BufferedImage> frames = new ArrayList<>();
        ImageReader reader = ImageIO.getImageReadersByFormatName("gif").next();
        File input = new File(gif);
        ImageInputStream stream = ImageIO.createImageInputStream(input);
        reader.setInput(stream);

        int count = reader.getNumImages(true);
        for (int index = 0; index < count; index++) {
             frames.add(reader.read(index));
        }
        return frames;
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

}