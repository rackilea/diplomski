import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ImageChangeDemo {

    private ImagePanel imagePanel = new ImagePanel();

    public ImageChangeDemo() {
        JFrame frame = new JFrame();
        frame.add(imagePanel);
        frame.add(createCombo(), BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JComboBox createCombo() {
        String[] items = {
            ImagePanel.DIRECTORY,
            ImagePanel.COMPUTER,
            ImagePanel.FILE,
            ImagePanel.FLOPPY,
            ImagePanel.HARD_DRIVE
        };
        JComboBox comboBox = new JComboBox(items);
        comboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                imagePanel.repaintBackground(comboBox.getSelectedItem().toString());
            }
        });
        return comboBox;
    }

    private class ImagePanel extends JPanel {
        public static final String DIRECTORY = "directory";
        public static final String FILE = "file";
        public static final String COMPUTER = "computer";
        public static final String HARD_DRIVE = "harddrive";
        public static final String FLOPPY = "floppy";

        Map<String, Image> images = new HashMap<>();

        private Image currentImage;

        public ImagePanel() {
            initImageMap();
            repaintBackground(DIRECTORY);
        }

        private void initImageMap() {
            ImageIcon dirIcon = (ImageIcon)UIManager.getIcon("FileView.directoryIcon");
            ImageIcon fileIcon =(ImageIcon)UIManager.getIcon("FileView.fileIcon");
            ImageIcon compIcon = (ImageIcon)UIManager.getIcon("FileView.computerIcon");
            ImageIcon hdIcon = (ImageIcon)UIManager.getIcon("FileView.hardDriveIcon");
            ImageIcon flopIcon = (ImageIcon)UIManager.getIcon("FileView.floppyDriveIcon");
            images.put(DIRECTORY, dirIcon.getImage());
            images.put(FILE, fileIcon.getImage());
            images.put(COMPUTER, compIcon.getImage());
            images.put(HARD_DRIVE, hdIcon.getImage());
            images.put(FLOPPY, flopIcon.getImage());
        }

        protected void repaintBackground(String key) {
            currentImage = images.get(key);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new ImageChangeDemo();
            }
        });
    }
}