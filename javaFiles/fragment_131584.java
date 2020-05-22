public static void main(String args[]) {
    JFrame window = new JFrame("l");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // <-- Handle closing 
                                           // the window.
    Color black = new Color(0, 0, 0);
    window.setBackground(black);
    window.setSize(new Dimension(500, 500)); // <-- set a size.
    window.setVisible(true); // <-- set it visible.
    JDialog start = new JDialog(window, ";;");
    start.setSize(new Dimension(300, 300)); // <-- set a size.
    start.setVisible(true); // <-- set it visible.
}