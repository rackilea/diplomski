/**
 * first discover all the numbering styles defined in the template.
 * a bit brute force since I can't find a way to just enumerate all the
 * abstractNum's inside the numbering.xml
 */
protected void initNumberingStyles() {
    numbering = document.getNumbering();

    BigInteger curIdx = BigInteger.ONE;
    XWPFAbstractNum abstractNum;

    while ((abstractNum = numbering.getAbstractNum(curIdx)) != null) {
        if (abstractNum != null) {
            CTString pStyle = abstractNum.getCTAbstractNum().getLvlArray(0).getPStyle();
            if (pStyle != null) {
                numberStyles.put(pStyle.getVal(), abstractNum);
            }
        }
        curIdx = curIdx.add(BigInteger.ONE);
    }

}