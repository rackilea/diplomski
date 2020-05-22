BufferedImage bgImage = createBgImageForText();
Graphics2D g = bgImage.createGraphics();
if ("Y".equalsIgnoreCase(player.getCaptain())) {
    g.setPaint(Color.BLACK);
} else {
    g.setPaint(Color.WHITE);
}
g.drawString(player.getPlayerName(), 25, 15);
g.dispose();