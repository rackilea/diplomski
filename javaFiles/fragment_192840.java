package convert;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class ZoomTest2 {
  public static void main(String[] args) {
    ImagePanel panel = new ImagePanel();
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(panel));
    f.setSize(1200, 1200);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class ImagePanel extends JPanel {
  BufferedImage image;
  double scale;

  public ImagePanel() {
    loadImage();
    scale = .38;
    addMouseWheelListener(new MouseWheelListener() {
      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
        int rotation = e.getWheelRotation();
        if (rotation < 0) {
          scale -= .05;
        } else {
          scale += .05;
        }
        if (scale < 0) {
          scale = 0;
        }
        revalidate();
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g.create();

    double x = (getWidth() - scale * image.getWidth()) / 2;
    double y = (getHeight() - scale * image.getHeight()) / 2;
    AffineTransform at = new AffineTransform();
    at.translate(x, y);
    at.scale(scale, scale);

    // g2.setTransform(at);
    // g2.drawImage(image, 0, 0, this);
    g2.drawImage(image, at, this);

    // or:
    // AffineTransform atf = g2.getTransform();
    // atf.concatenate(at);
    // g2.setTransform(atf);
    // g2.drawImage(image, 0, 0, this);

    g2.dispose();
  }

  public Dimension getPreferredSize() {
    int w = (int)(scale * image.getWidth());
    int h = (int)(scale * image.getHeight());
    return new Dimension(w, h);
  }

  private void loadImage() {
    String fileName = "aaa.png";
    try {
      image = ImageIO.read(new File(fileName));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}