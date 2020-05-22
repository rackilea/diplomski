JFormattedTextField field = new JFormattedTextField(getMaskFormatter("######.##"));

(...)

private MaskFormatter getMaskFormatter(String format) {
    MaskFormatter mask = null;
    try {
        mask = new MaskFormatter(format);
        mask.setPlaceholderCharacter('0');
    }catch (ParseException ex) {
        ex.printStackTrace();
    }
    return mask;
}