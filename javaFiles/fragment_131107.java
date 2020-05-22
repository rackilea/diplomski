public class TransparentButton  {

    public TransparentButton() {
        JWindow incorrectOpaque = createWindow("incorrect opaque", true);
        incorrectOpaque.setLocation(600, 600);
        incorrectOpaque.setVisible(true);
        JWindow correctOpaque = createWindow("correct opaque", false);
        correctOpaque.setLocation(800, 600);
        correctOpaque.setVisible(true);
    }


    private JButton createButton(final boolean opaque) {
        JButton but = new JButton("Testing") {

            /**
             * @inherited <p>
             * Overridden to take over background painting with 
             * transparent color.
             */
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBackground().getAlpha() < 255) {
                    g.setColor(getBackground());
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
                super.paintComponent(g);
            }

        };
        but.setBackground(new Color(0, 0, 0, 100));
        but.setForeground(new Color(70, 155, 255));
        but.setOpaque(opaque);
        return but;
    }

    private JWindow createWindow(String text, boolean opaque) {
        JWindow window = new JWindow();
        JButton but = createButton(opaque);
        window.add(but);
        window.add(new JLabel(""), BorderLayout.SOUTH);
        window.setOpacity(0.5f);
        window.setBackground(new Color(0, 0, 0, 0));
        window.setSize(new Dimension(200, 100));
        return window;
    }

    public static void main(String[] Args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new TransparentButton();
            }
        });
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(TransparentButton.class
            .getName());
}