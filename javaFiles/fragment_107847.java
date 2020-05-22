class PercentageFilter extends DocumentFilter {
    insertString(FilterBypass bp, int offset, String adding, AttributeSet attrs) {
        Document doc = bp.getDocument();
        String text = doc.getText(0, offset) + adding + doc.getText(offset, doc.getLength()-offset);
        try {
            double d = Double.parseDouble(text);
            if(d < 0 || 100 < d) {
                // to big or too small number
                return;
            }
        }
        catch(NumberFormatException ex) {
            // invalid number, do nothing.
            return;
        }
        // if we come to this point, the entered number
        // is a valid value => really insert it into the document.
        bp.insertString(offset, adding, attrs);
    }
}