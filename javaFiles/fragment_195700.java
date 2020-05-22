try {
    BufferedImage original = ImageIO.read(getClass().getResource("domino.jpg"));
    BufferedImage rotated90 = rotate(original, 90.0d);
    BufferedImage rotatedMinus90 = rotate(original, -90.0d);

    JPanel panel = new JPanel();
    panel.add(new JLabel(new ImageIcon(original)));
    panel.add(new JLabel(new ImageIcon(rotated90)));
    panel.add(new JLabel(new ImageIcon(rotatedMinus90)));

    JOptionPane.showMessageDialog(null, panel, null, JOptionPane.PLAIN_MESSAGE, null);
} catch (IOException ex) {
    ex.printStackTrace();
}