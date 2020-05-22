protected void setPropertiesFromAttributes() {
    StyleSheet sheet = getStyleSheet();
    this.attr = sheet.getViewAttributes(this);

    // Gutters
    borderSize = (short)getIntAttr(HTML.Attribute.BORDER, isLink() ?
                                   DEFAULT_BORDER : 0);

    leftInset = rightInset = (short)(getIntAttr(HTML.Attribute.HSPACE,
                                                0) + borderSize);
    topInset = bottomInset = (short)(getIntAttr(HTML.Attribute.VSPACE,
                                                0) + borderSize);

    borderColor = ((StyledDocument)getDocument()).getForeground
                  (getAttributes());

    AttributeSet attr = getElement().getAttributes();

    // Alignment.
    // PENDING: This needs to be changed to support the CSS versions
    // when conversion from ALIGN to VERTICAL_ALIGN is complete.
    Object alignment = attr.getAttribute(HTML.Attribute.ALIGN);

    vAlign = 1.0f;
    if (alignment != null) {
        alignment = alignment.toString();
        if ("top".equals(alignment)) {
            vAlign = 0f;
        }
        else if ("middle".equals(alignment)) {
            vAlign = .5f;
        }
    }

    AttributeSet anchorAttr = (AttributeSet)attr.getAttribute(HTML.Tag.A);
    if (anchorAttr != null && anchorAttr.isDefined
        (HTML.Attribute.HREF)) {
        synchronized(this) {
            state |= LINK_FLAG;
        }
    }
    else {
        synchronized(this) {
            state = (state | LINK_FLAG) ^ LINK_FLAG;
        }
    }
}