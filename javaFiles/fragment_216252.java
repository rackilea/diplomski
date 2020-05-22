String propVal = placeholderResolver.resolvePlaceholder(placeholder);
if (propVal == null && this.valueSeparator != null) {
    int separatorIndex = placeholder.indexOf(this.valueSeparator);
    if (separatorIndex != -1) {
        String actualPlaceholder = placeholder.substring(0, separatorIndex);
        String defaultValue = placeholder.substring(separatorIndex + this.valueSeparator.length());
        propVal = placeholderResolver.resolvePlaceholder(actualPlaceholder);
        if (propVal == null) {
            propVal = defaultValue;
        }
    }
}