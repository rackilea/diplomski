public static Attributes filterDefaults(Attributes attributes) {
    // Either test the feature flag, or do an instance test
    Attributes2 attrs = (Attributes2) attributes;
    Attributes2Impl newAttrs = new Attributes2Impl();
    for (int i = 0; i < attrs.getLength(); i++) {
        if (attrs.isSpecified(i)) {
            final String qName = attrs.getQName(i);
            final String type = attrs.getType(i);
            final String value = attrs.getValue(i);
            newAttrs.addAttribute(null, null, qName, type, value);
        }
    }
    return newAttrs;
}