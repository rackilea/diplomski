BigDecimal bd = new BigDecimal("-1.30").setScale(2, RoundingMode.HALF_UP);
String textBD = bd.toPlainString();
System.out.println("text version, length = <" + textBD + ">, " + textBD.length());
int radixLoc = textBD.indexOf('.');
System.out.println("Fraction " + textBD.substring(0, radixLoc)
    + ". Cents: " + textBD.substring(radixLoc + 1, textBD.length()));