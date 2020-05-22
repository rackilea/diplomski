try {
    URL url = new URL(JSONLists.thumbnail.get(page));
    BufferedImage image = ImageIO.read(url);
    JLabel label = new JLabel(new ImageIcon(image));
    panelForm.add(label); //here
} catch (Exception exp) {
    exp.printStackTrace();
}