public Font getFont() throws IOException, FontFormatException {
        File f = File.createTempFile("dang", "tmp");
        assert f != null;
        f.delete();
        ClassLoader classLoader = getClass().getClassLoader();
        Font font = Font.createFont(Font.TRUETYPE_FONT, classLoader.getResourceAsStream("EuroPlate.ttf"));
        font.deriveFont(105f);
        System.out.println(font.getFontName());
        return font;
    }