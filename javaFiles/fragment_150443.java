public class PaintIcon {

    public static void main(String[] args) {
        new PaintIcon();
    }

    public PaintIcon() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new PaintPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PaintPane extends JPanel {

        private JLabel label;
        private int state = 0;

        private BufferedImage disk;
        private BufferedImage play;
        private BufferedImage pause;
        private BufferedImage stop;

        public PaintPane() {

            setLayout(new GridBagLayout());
            add((label = new JLabel()));

            try {
                disk = ImageIO.read(getClass().getResource("/cd.png"));
                play = ImageIO.read(getClass().getResource("/media_play.png"));
                pause = ImageIO.read(getClass().getResource("/media_pause.png"));
                stop = ImageIO.read(getClass().getResource("/media_stop.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            updateState();

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    state++;
                    if (state > 2) {
                        state = 0;
                    }
                    updateState();
                }
            });
        }

        protected void updateState() {
            BufferedImage base = new BufferedImage(disk.getWidth(), disk.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = base.createGraphics();
            g2d.drawImage(disk, 0, 0, this);
            BufferedImage marker = null;
            switch (state) {
                case 0:
                    marker = stop;
                    break;
                case 1:
                    marker = play;
                    break;
                case 2:
                    marker = pause;
                    break;
            }
            int x = disk.getWidth() - marker.getWidth();
            int y = disk.getHeight() - marker.getHeight();
            g2d.drawImage(marker, x, y, this);
            g2d.dispose();

            label.setIcon(new ImageIcon(base));
        }
    }
}