public class TestMouseCursor {

    public static void main(String[] args) {
        new TestMouseCursor();
    }

    public TestMouseCursor() {
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

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MouseCursorPane());
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MouseCursorPane extends JPanel {

        private BufferedImage cursorImage;
        private Toolkit kit;

        public MouseCursorPane() {
            try {
                kit = Toolkit.getDefaultToolkit();
                cursorImage = ImageIO.read(getClass().getResource("/cursor02.png"));
                for (int i = 0; i < cursorImage.getHeight(); i++) {
                    int[] rgb = cursorImage.getRGB(0, i, cursorImage.getWidth(), 1, null, 0, cursorImage.getWidth() * 4);
                    for (int j = 0; j < rgb.length; j++) {
                        int alpha = (rgb[j] >> 24) & 255;
                        if (alpha < 128) {
                            alpha = 0;
                        } else {
                            alpha = 255;
                        }
                        rgb[j] &= 0x00ffffff;
                        rgb[j] = (alpha << 24) | rgb[j];
                    }
                    cursorImage.setRGB(0, i, cursorImage.getWidth(), 1, rgb, 0,
                            cursorImage.getWidth() * 4);
                }
                Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(
                        cursorImage, new Point(0, 0), "CustomCursor");

                setCursor(cursor);

            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }
}