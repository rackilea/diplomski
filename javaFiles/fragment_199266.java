public static void getBufferedImage(Image image, Consumer<Image> imageConsumer) {

    image.getWidth((img, info, x, y, w, h) -> {
        if (info == ImageObserver.ALLBITS) {
            BufferedImage buffered = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = buffered.createGraphics();
            g2.setColor(Color.WHITE); // You choose the background color
            g2.fillRect(0, 0, w, h);
            if (g2.drawImage(img, 0, 0, w, h, (img2, info2, x2, y2, w2, h2) -> {
                if (info2 == ImageObserver.ALLBITS) {
                    g2.dispose();
                    imageConsumer.accept(img2);
                    return false;
                }
                return true;
            })) {
                g2.dispose();
                imageConsumer.accept(buffered);
            }
            return false;
        }
        return true;
    });
}

public static void setClipboard(Image image) {
    boolean testBuffered = true; // Both buffered and non-buffered worked for me
    if (!testBuffered) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new ImageSelection(image), null);
    } else {
        getBufferedImage(image, (buffered) -> {
            ImageSelection imgSel = new ImageSelection(buffered);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSel, null);
        });
    }
}