package opencv.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class OpenCVMyGui {

    private JFrame frame;
    ImageResultPanel panel_bot;
    ImageChoosePanel panel_left;
    ImageChoosePanel panel_right;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OpenCVMyGui window = new OpenCVMyGui();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public OpenCVMyGui() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);

        panel_left = new ImageChoosePanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 0;
        frame.getContentPane().add(panel_left, gbc_panel_2);

        panel_right = new ImageChoosePanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 0);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 1;
        gbc_panel_1.gridy = 0;
        frame.getContentPane().add(panel_right, gbc_panel_1);

        panel_bot = new ImageResultPanel(this);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 2;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 1;
        frame.getContentPane().add(panel_bot, gbc_panel);
    }

    private class ImageChoosePanel extends JPanel {

        /**
         * 
         */
        private static final long serialVersionUID = 2207576827793103205L;
        public BufferedImage image;
        public File file;

        public ImageChoosePanel() {
            setFocusable(true);
            addMouseListener(new MouseListener() {

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    chooser.setFileFilter(new FileNameExtensionFilter("Images",
                            "jpg", "png")); // maybe more? dont know what OpenCV
                                            // likes
                    chooser.showOpenDialog(ImageChoosePanel.this);
                    ImageChoosePanel icp = ((ImageChoosePanel) e.getSource());
                    icp.file = chooser.getSelectedFile();
                    try {
                        image = ImageIO.read(icp.file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        @Override
        public void paint(Graphics arg0) {

            if (image != null) {
                arg0.drawImage(image, 0, 0, null);
            } else{ 
                arg0.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }

    private class ImageResultPanel extends JPanel {

        /**
         * 
         */
        private static final long serialVersionUID = 8948107638933808175L;
        public BufferedImage image;
        OpenCVMyGui gui;

        public ImageResultPanel(OpenCVMyGui gui) {
            this.gui = gui;
            setFocusable(true);
            addMouseListener(new MouseListener() {

                @Override
                public void mouseReleased(MouseEvent arg0) {
                }

                @Override
                public void mousePressed(MouseEvent arg0) {
                }

                @Override
                public void mouseExited(MouseEvent arg0) {
                }

                @Override
                public void mouseEntered(MouseEvent arg0) {
                }

                @Override
                public void mouseClicked(MouseEvent arg0) {
                    try {
                        OpenCVMyGui gui = ((ImageResultPanel) arg0.getSource()).gui;
                        image = MatchDetection.detectMatches(
                                gui.panel_right.file, gui.panel_left.file);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }

        @Override
        public void paint(Graphics arg0) {
            if (image != null) {
                arg0.drawImage(image, 0, 0, null);
            }else{
                arg0.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }

}