/**
 * Update any cached values that come from attributes.
 */
protected void setPropertiesFromAttributes() {
    StyleSheet sheet = getStyleSheet();
    this.attr = sheet.getViewAttributes(this);

    //...

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