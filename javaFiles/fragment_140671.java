import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SlideShow {

    public static void main(String[] args) {
        new SlideShow();
    }

    public SlideShow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();

                Rectangle bounds = gd.getDefaultConfiguration().getBounds();
                System.out.println(bounds);

                SlideShowPane slideShowPane = new SlideShowPane();
                JFrame frame = new JFrame("Image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(slideShowPane);
                frame.pack();
                int x = (bounds.x + (bounds.width / 2)) - frame.getWidth();
                int y = (bounds.y + (bounds.height - frame.getHeight()) / 2);
                frame.setLocation(x, y);
                frame.setVisible(true);

                JFrame browser = new JFrame("Browser");
                browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                browser.add(new BrowserPane(slideShowPane));
                browser.pack();
                x = (bounds.x + (bounds.width / 2)) + browser.getWidth();
                y = (bounds.y + (bounds.height - browser.getHeight()) / 2);
                browser.setLocation(x, y);
                browser.setVisible(true);
            }
        });
    }

    public class BrowserPane extends JPanel {

        private SlideShowPane slideShowPane;
        private JFileChooser chooser;

        private BrowserPane(SlideShowPane pane) {
            this.slideShowPane = pane;
            setLayout(new GridBagLayout());
            JButton browse = new JButton("...");
            add(browse);
            browse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chooser == null) {
                        chooser = new JFileChooser();
                        chooser.setMultiSelectionEnabled(false);
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    }

                    switch (chooser.showOpenDialog(BrowserPane.this)) {
                        case JFileChooser.APPROVE_OPTION:
                            File path = chooser.getSelectedFile();
                            slideShowPane.setPath(path);
                            break;
                    }
                }
            });
        }

    }

    public class SlideShowPane extends JPanel {

        private File path;
        private Timer timer;
        private List<File> imageList;
        private int nextImage;
        private Image currentImage;

        public SlideShowPane() {
            imageList = new ArrayList<>(25);
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (imageList != null && !imageList.isEmpty()) {
                        nextImage++;
                        if (nextImage >= imageList.size()) {
                            nextImage = 0;
                        }
                        System.out.println("NextImage = " + nextImage);
                        do {
                            try {
                                File file = imageList.get(nextImage);
                                System.out.println("Load " + file);
                                currentImage = ImageIO.read(file);
                            } catch (IOException ex) {
                                currentImage = null;
                                nextImage++;
                                ex.printStackTrace();
                            }
                        } while (currentImage == null && nextImage < imageList.size());
                        repaint();
                    }
                }
            });
            timer.setInitialDelay(0);
        }

        public void setPath(File path) {
            System.out.println("SetPath");
            this.path = path;
            timer.stop();
            imageList.clear();
            currentImage = null;
            if (path.isDirectory()) {
                File files[] = path.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        String name = pathname.getName().toLowerCase();
                        return name.endsWith(".jpg")
                                        || name.endsWith(".jpeg")
                                        || name.endsWith(".png")
                                        || name.endsWith(".bmp")
                                        || name.endsWith(".gif");
                    }
                });
                if (files != null) {
                    System.out.println("Found " + files.length + " matches");
                    imageList.addAll(Arrays.asList(files));
                }
            }

            if (imageList.isEmpty()) {
                repaint();
            } else {
                System.out.println("Start timer...");
                nextImage = -1;
                timer.restart();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (currentImage != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - currentImage.getWidth(this)) / 2;
                int y = (getHeight() - currentImage.getHeight(this)) / 2;
                g2d.drawImage(currentImage, x, y, this);
                g2d.dispose();
            }
        }

    }

}