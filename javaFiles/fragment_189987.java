@Override
public void handleStartTag(Tag t, MutableAttributeSet a, int pos) {
    if (Tag.DIV.equals(t)) {
        String id = (String) a.getAttribute(HTML.Attribute.ID);
        String clazz = (String) a.getAttribute(HTML.Attribute.CLASS);
        ...