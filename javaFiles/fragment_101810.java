int value = 0;
if (StringUtils.isNumeric(tokens.get(2))) {
    value = Integer.parseInt(tokens.get(2));
}
// Default value will be 0.
expression.put(tokens.get(0), value);