public class TestScreenSize {

    public static void main(String[] args) {
        new TestScreenSize();
    }

    public TestScreenSize() {
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

                Test test = new Test();
                test.setLayout(new BorderLayout());
                test.setVisible(true);
                System.exit(0);
            }
        });
    }

    public class Test extends JDialog {

        public Test() {
            setModal(true);
            setLocation(0, 0);
            setSize(2000, 2000);
        }

        @Override
        public void setBounds(int x, int y, int width, int height) {
            Rectangle bounds = getSafeScreenBounds(new Point(x, y));
            if (x < bounds.x) {
                x = bounds.x;
            }
            if (y < bounds.y) {
                y = bounds.y;
            }
            if (width > bounds.width) {
                width = (bounds.x + bounds.width) - x;
            }
            if (height > bounds.height) {
                height = (bounds.y + bounds.height) - y;
            }
            super.setBounds(x, y, width, height);
        }

    }

    public static Rectangle getSafeScreenBounds(Point pos) {

        Rectangle bounds = getScreenBoundsAt(pos);
        Insets insets = getScreenInsetsAt(pos);

        bounds.x += insets.left;
        bounds.y += insets.top;
        bounds.width -= (insets.left + insets.right);
        bounds.height -= (insets.top + insets.bottom);

        return bounds;

    }

    public static Insets getScreenInsetsAt(Point pos) {
        GraphicsDevice gd = getGraphicsDeviceAt(pos);
        Insets insets = null;
        if (gd != null) {
            insets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());
        }
        return insets;
    }

    public static Rectangle getScreenBoundsAt(Point pos) {
        GraphicsDevice gd = getGraphicsDeviceAt(pos);
        Rectangle bounds = null;
        if (gd != null) {
            bounds = gd.getDefaultConfiguration().getBounds();
        }
        return bounds;
    }

    public static GraphicsDevice getGraphicsDeviceAt(Point pos) {

        GraphicsDevice device = null;

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();

        ArrayList<GraphicsDevice> lstDevices = new ArrayList<GraphicsDevice>(lstGDs.length);

        for (GraphicsDevice gd : lstGDs) {

            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            Rectangle screenBounds = gc.getBounds();

            if (screenBounds.contains(pos)) {

                lstDevices.add(gd);

            }

        }

        if (lstDevices.size() > 0) {
            device = lstDevices.get(0);
        } else {
            device = ge.getDefaultScreenDevice();
        }

        return device;

    }
}