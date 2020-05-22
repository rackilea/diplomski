public class TestInternalFrame {

    public static void main(String[] args) {
        new TestInternalFrame();
    }

    public TestInternalFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JDesktopPane desktop = new JDesktopPane();

                final JInternalFrame frame1 = new JInternalFrame("Image on Label");
//                frame1.setContentPane(new LabelImagePane());
//                frame1.pack();
//                frame1.setLocation(0, 0);
                frame1.setVisible(true);
                desktop.add(frame1);

                final JInternalFrame frame2 = new JInternalFrame("Painted Image");
//                frame2.setContentPane(new ImagePane());
//                frame2.pack();
//                frame2.setLocation(frame1.getWidth(), 0);
                frame2.setVisible(true);
                desktop.add(frame2);


                JFrame frame = new JFrame("I Haz Images");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(desktop);
                frame.setSize(800, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        frame1.setContentPane(new LabelImagePane());
                        frame1.pack();
                        frame1.setLocation(0, 0);
                        frame2.setContentPane(new ImagePane());
                        frame2.pack();
                        frame2.setLocation(frame1.getWidth(), 0);
                    }
                });

            }
        });
    }

    public class LabelImagePane extends JPanel {

        public LabelImagePane() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel();
            add(label);

            try {
                label.setIcon(new ImageIcon(ImageIO.read(new File("..."))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class ImagePane extends JPanel {

        private BufferedImage image;

        public ImagePane() {
            try {
                image = ImageIO.read(new File("..."));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                int x = (getWidth() - image.getWidth()) / 2;
                int y = (getHeight() - image.getHeight()) / 2;
                g.drawImage(image, x, y, this);
            }
        }
    }
}