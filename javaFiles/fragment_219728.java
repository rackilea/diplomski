String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();
        System.out.println(fonts.length + " font families installed");
        Vector<String> supportedFonts = new Vector<>();
        for (String fontName : fonts) {
            Font f = new Font(fontName, Font.PLAIN, 1);
            if (f.canDisplayUpTo(text)<0) {
                System.out.println(fontName);
                supportedFonts.add(fontName);
            }
        }
        fontComboBox = new JComboBox(supportedFonts);