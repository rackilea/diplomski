public static void main(String[] args) throws MalformedURLException {

    URL url = new URL("<URL to your Animated GIF>");
    Icon icon = new ImageIcon(url);
    JLabel label = new JLabel(icon);

    JFrame f = new JFrame("Animation");
    f.getContentPane().add(label);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
}