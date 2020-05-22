final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("Roboto-Thin.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, stream);
            System.out.println("Font: " + font);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
        }