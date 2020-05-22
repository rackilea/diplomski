public class ImageTool extends JPanel {
    public ImageTool(URL url) {
        ImageIcon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon, JLabel.CENTER);
        add(label);

        System.out.println("Image width: " + icon.getIconWidth());
        System.out.println("Image height: " + icon.getIconHeight());
    }

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.java2s.com/style/logo.png");
        JPanel panel = new ImageTool(url);
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}