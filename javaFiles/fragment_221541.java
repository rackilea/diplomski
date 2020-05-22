import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class TestPaint {

    protected void initUI() {
        StringBuilder sb = new StringBuilder("<html>");
        sb.append("<table>");
        for (int i = 0; i < 5; i++) {
            sb.append("<tr>");
            for (int j = 0; j < 5; j++) {
                sb.append("<td>");
                sb.append("Cell ").append(i + 1).append(' ').append(j + 1);
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        JLabel label = new JLabel(sb.toString());
        label.setSize(label.getPreferredSize());
        BufferedImage image = new BufferedImage(label.getWidth(), label.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.paint(g2d);
        g2d.dispose();
        File file = new File("/tmp/test.png");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream baos = null;
        try {
            baos = new FileOutputStream(file);
            ImageIO.write(image, "png", baos);


        Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestPaint().initUI();
            }

        });
    }
}