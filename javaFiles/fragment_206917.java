public class FxFontMetrics {
    public static void main(String[] args) {
        int maxWidth = 100;
        System.out.println("# Text -> Font size that can fit text under " + maxWidth + " pixels");
        Stream.of(
                "DINHEIRO FICTICIO",
                "Dinheiro ficticio",
                "PLAY MONEY",
                "Play money",
                "Devise factice qui compte pour du beurre")
                .forEach(text -> {
                    double size = findFontSizeThatCanFit(Font.font("dialog", 45), text, maxWidth);
                    System.out.println(text + " -> " + size);
                });
    }

    private static double findFontSizeThatCanFit(Font font, String s, int maxWidth) {
        double fontSize = font.getSize();
        double width = textWidth(font, s);
        if (width > maxWidth) {
            return fontSize * maxWidth / width;
        }
        return fontSize;
    }

    private static double textWidth(Font font, String s) {
        Text text = new Text(s);
        text.setFont(font);
        return text.getBoundsInLocal().getWidth();
    }
}