private static final Font FONT = new Font("Serif", Font.PLAIN, 14);
private static final float PARAGRAPH_BREAK = 10;
private static final float MARGIN = 20;

private Graphics2D setupGraphics(BufferedImage img) {
    Graphics2D g2d = img.createGraphics();
    g2d.setFont(FONT);
    g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
    g2d.setColor(Color.BLACK);
    return g2d;
}

private List<BufferedImage> renderText(String str, int width, int height) {
    String[] paragraphs = str.split("\n");

    List<BufferedImage> images = new ArrayList<>();

    BufferedImage img = new BufferedImage(width, 
            height, 
            BufferedImage.TYPE_3BYTE_BGR);
    images.add(img);
    Graphics2D g2d = setupGraphics(img);

    float drawPosY = 0;

    for (int paragraph=0;paragraph<paragraphs.length;paragraph++) {

        drawPosY += PARAGRAPH_BREAK;

        AttributedString attStr = new AttributedString(paragraphs[paragraph]);
        AttributedCharacterIterator it = attStr.getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(it, g2d.getFontRenderContext());
        measurer.setPosition(it.getBeginIndex());

        while (measurer.getPosition() < it.getEndIndex()) {
            TextLayout layout = measurer.nextLayout(img.getWidth()-MARGIN*2);

            if (drawPosY > img.getHeight() - layout.getAscent() - layout.getDescent() - layout.getLeading()) {
                drawPosY = 0;
                img = new BufferedImage((int)(
                        width, 
                        height, 
                        BufferedImage.TYPE_3BYTE_BGR);
                images.add(img);
                g2d.dispose();
                g2d = setupGraphics(img);
            }

            drawPosY += layout.getAscent();

            layout.draw(g2d, MARGIN, drawPosY);

            drawPosY += layout.getDescent()+layout.getLeading();
        }
    }
    g2d.dispose();

    return images;
}