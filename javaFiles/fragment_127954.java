void updateHighlight(StyledDocument doc,
                     AttributeSet newStyle) {

    Object styleName = newStyle.getAttribute(AttributeSet.NameAttribute);

    ElementIterator i = new ElementIterator(doc);
    for (Element e = i.first(); e != null; e = i.next()) {
        AttributeSet attr = e.getAttributes();
        Object name = attr.getAttribute(AttributeSet.NameAttribute);
        if (styleName.equals(name)) {
            int start = e.getStartOffset();
            int end = e.getEndOffset();
            doc.setCharacterAttributes(start, end - start,
                newStyle, false);
        }
    }
}