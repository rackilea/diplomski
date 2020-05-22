public class Execute {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final Color bcolor = new Color(254, 0, 0);

                final Window wndw = new Window("Test", 1000, 1000, bcolor, true);

            }
        });

    }

}

public class Window extends JFrame {
    Window(final String name, final int width, final int length, final Color backgroundColor,
            final boolean visible) {

        System.out.println("made it to frame class");
        this.setTitle(name);
        this.setSize(width, length);
        this.getContentPane().setBackground(backgroundColor);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(visible);

    }
}