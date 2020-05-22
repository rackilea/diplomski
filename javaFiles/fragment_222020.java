public enum FramePool {
    INSTANCE;

    private int minSize = 15;
    private int maxSize = 25;

    private List<ImageFrame> avaliable;

    private FramePool() {
        avaliable = new ArrayList<>(25);

        for (int index = 0; index < minSize; index++) {
            avaliable.add(new ImageFrame());
        }
    }

    public synchronized ImageFrame grab() {
        ImageFrame frame;
        System.out.println(avaliable.size());
        if (avaliable.isEmpty()) {
            System.out.println("Make new");
            frame = new ImageFrame();
        } else {
            frame = avaliable.remove(0);
        }

        return frame;
    }

    public synchronized void release(ImageFrame frame) {
        if (avaliable.size() < maxSize) {
            avaliable.add(frame);
        } else {
            System.out.println("Destory");
            frame.dispose();
        }
    }

    public class ImageFrame extends JFrame {

        private JLabel label;
        private int timeout = 150;

        public ImageFrame() throws HeadlessException {
            label = new JLabel();
            add(label);
            setUndecorated(true);
            setBackground(new Color(0, 0, 0, 0));
            setAlwaysOnTop(true);
            setFocusableWindowState(false);
            setFocusable(false);
            pack();

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    System.out.println("Show me");
                    Timer timer = new Timer(timeout, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Hide me");
                            setVisible(false);
                            System.out.println("Return");
                            FramePool.INSTANCE.release(ImageFrame.this);
                        }
                    });
                    timer.start();
                }

            });
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public void setImage(Image image) {
            label.setIcon(new ImageIcon(image));
            pack();

            Rectangle bounds = new Rectangle(0, 0, 0, 0);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();

            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            bounds = gc.getBounds();

            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);

            bounds.x += insets.left;
            bounds.y += insets.top;
            bounds.width -= (insets.left + insets.right);
            bounds.height -= (insets.top + insets.bottom);

            int x = (int) (Math.random() * bounds.width);
            int y = (int) (Math.random() * bounds.height);

            if (x + getWidth() > bounds.width) {
                x = bounds.width - getWidth();
                if (x < 0) {
                    x = 0;
                }
            }
            if (y + getHeight() > bounds.height) {
                y = bounds.height - getHeight();
                if (y < 0) {
                    y = 0;
                }
            }

            setLocation(bounds.x + x, bounds.y + y);
        }

    }
}