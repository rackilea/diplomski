//Line 355 -- com.sun.faces.renderkit.html_basic.HtmlBasicRenderer
//method getCurrentValue

    Object currentObj = getValue(component);
    if (currentObj != null) {
        currentValue = getFormattedValue(context, component, currentObj);
    }