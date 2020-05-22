private static void createAndShowGui() {
    BufferedImage img = null;
    try {
        URL imgUrl = new URL(IMG_PATH);
        img = ImageIO.read(imgUrl);
    } catch (IOException e) {
        e.printStackTrace();
        System.exit(-1);
    }

    CenteredImage centeredImagePanel = new CenteredImage(img);

    JPanel wrapperPanel = new JPanel(new GridBagLayout());
    wrapperPanel.add(centeredImagePanel);

    JFrame frame = new JFrame("CenteredImage");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(800, 650));
    // frame.getContentPane().setLayout(new GridBagLayout());
    frame.getContentPane().add(wrapperPanel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> createAndShowGui());
}