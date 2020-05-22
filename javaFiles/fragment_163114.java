/**
 * This creates a new num based upon the specified numberStyle
 * @param numberStyle
 * @return
 */
private XWPFNum restartNumbering(String numberStyle) {
    XWPFAbstractNum abstractNum = numberStyles.get(numberStyle);
    BigInteger numId = numbering.addNum(abstractNum.getAbstractNum().getAbstractNumId());
    XWPFNum num = numbering.getNum(numId);
    CTNumLvl lvlOverride = num.getCTNum().addNewLvlOverride();
    lvlOverride.setIlvl(BigInteger.ZERO);
    CTDecimalNumber number = lvlOverride.addNewStartOverride();
    number.setVal(BigInteger.ONE);
    return num;
}