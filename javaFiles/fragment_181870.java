private static String ITEMS[] = { "Buggy!", "New Game!",
        "Roll up, roll up!", "Made from Scratch" };

private String itemDisplayed = chooseItem();

private String chooseItem() {
    Random r = new SecureRandom();
    int i = r.nextInt(ITEMS.length);
    return ITEMS[i];
}

private void drawSplash(Graphics2D g) {
    g.setColor(Color.BLACK);
    g.setFont(font2);
    g.drawString(itemDisplayed, 320, 240);
    displayed = true;
}