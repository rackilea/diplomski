public View create(Element elem) {
    Document doc = elem.getDocument();
    Object i18nFlag = doc.getProperty("i18n"/*AbstractDocument.I18NProperty*/);
    if ((i18nFlag != null) && i18nFlag.equals(Boolean.TRUE)) {
        // build a view that support bidi
        return createI18N(elem);
    } else {
        JTextComponent c = getComponent();
        if (c instanceof JTextArea) {
        JTextArea area = (JTextArea) c;
        View v;
        if (area.getLineWrap()) {
            v = new WrappedPlainView(elem, area.getWrapStyleWord());
        } else {
            v = new PlainView(elem);
        }
        return v;
        }
    }
    return null;
}