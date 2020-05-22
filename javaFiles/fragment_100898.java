try {
    NumberFormat nf = NumberFormat.getIntegerInstance(locale);
    nf.setParseIntegerOnly(true);
    nf.setMaximumIntegerDigits(9); // Or whatever you'd like to max out at.

    // Start parsing from the beginning.
    ParsePosition p = new ParsePosition(0);

    int val = format.parse(str, p).intValue();
    if (p.getIndex() != str.length()) {
        // There's some stuff after all the digits are done being processed.
    }

    // Work with the processed value here.
} catch (java.text.ParseFormatException exc) {
    // Something blew up in the parsing.
}