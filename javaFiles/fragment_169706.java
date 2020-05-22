if (input instanceof String) {
    try {
    if (((String) input).indexOf('.') != -1) {
                // String value is interpreted as a double
        input = Double.valueOf((String) input);
    } else {
                // String value is interpreted as a long
        input = Long.valueOf((String) input);
    }
    } catch (NumberFormatException nfe) {
    throw new JspException(
                Resources.getMessage("FORMAT_NUMBER_PARSE_ERROR", input),
        nfe);
    }
}