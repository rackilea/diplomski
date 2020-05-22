for (Iterator i = UIManager.getLookAndFeelDefaults().keySet().iterator(); i.hasNext();) {
    String key = (String) i.next();
    if(key.endsWith(".font")) {
        Font font = UIManager.getFont(key);
        Font biggerFont = font.deriveFont(2.0f*font.getSize2D());
        // change ui default to bigger font
        UIManager.put(key,biggerFont);
    }
}