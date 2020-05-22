public static void setUIFontSize(int newSize) {
    Enumeration<Object> keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        Object value = UIManager.get(key);
        if (value != null
                && value instanceof javax.swing.plaf.FontUIResource) {
            FontUIResource oldFont = (FontUIResource) value;
            UIManager.put(key, oldFont.deriveFont((float) newSize));
        }
    }
}