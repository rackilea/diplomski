/**
 * This creates a five item list with a simple heading, using the specified style..
 * @param index
 * @param styleName
 */
protected void createStyledNumberList(int index, String styleName) {
    XWPFParagraph p = document.createParagraph();
    XWPFRun run = p.createRun();
    run.setText(String.format("List %d: - %s", index, styleName));

    // restart numbering
    XWPFNum num = restartNumbering(styleName);

    for (int i=1; i<=5; i++) {
        XWPFParagraph p2 = document.createParagraph();

        // set the style for this paragraph
        p2.setStyle(styleName);

        // set numbering for paragraph
        p2.setNumID(num.getCTNum().getNumId());
        CTNumPr numProp = p2.getCTP().getPPr().getNumPr();
        numProp.addNewIlvl().setVal(BigInteger.ZERO);

        // set the text
        XWPFRun run2 = p2.createRun();
        run2.setText(String.format("Item #%d using '%s' style.", i, styleName));
    }

    // some whitespace
    p = document.createParagraph();
    p.createRun();

}