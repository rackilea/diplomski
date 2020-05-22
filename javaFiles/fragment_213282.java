private String getAttributeStringValue(AttributeSet attrs, String namespace,
                                       String name, String defaultValue) {

    String value = null;
    int resId = attrs.getAttributeResourceValue(namespace, name, 0);

    if (resId == 0) {
        value = attrs.getAttributeValue(namespace, name);
        if (value == null)
            value = defaultValue;
    }
    else {
        value = getContext().getResources().getString(resId);
    }

    return value;
}