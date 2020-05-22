private static void setFontSize() {
    int fontSize = 12;
    Hashtable defaults = UIManager.getDefaults();
    Enumeration keys = defaults.keys();
    while (keys.hasMoreElements()) {
        Object key = keys.nextElement();

        if ((key instanceof String) && (((String) key).endsWith(".font"))) {
            FontUIResource font = (FontUIResource) UIManager.get(key);
            defaults.put (key, new FontUIResource(font.getFontName(), font.getStyle(), fontSize));
        }
    }
 }