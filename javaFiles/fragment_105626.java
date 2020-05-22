public static BigDecimal pow(BigDecimal x, BigDecimal y)
{
    BigDecimal val = BigFunctions.ln(x, 33).setScale(32, RoundingMode.HALF_UP).multiply(y);
    BigDecimal result = BigFunctions.exp(val, 33).setScale(32, RoundingMode.HALF_UP);

    String regExp = "0{30}", resultString = result.toPlainString();
    int commaIndex = resultString.indexOf(".");
    Pattern pattern = Pattern.compile(regExp);
    Matcher matcher = pattern.matcher(resultString.substring(commaIndex));
    boolean hasMatch = matcher.find();
    if(hasMatch == true)
    {
        return new BigDecimal(resultString.substring(0, commaIndex));
    }
    return result;
}