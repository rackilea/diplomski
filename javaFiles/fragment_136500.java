private static String replaceMatchPow(String pValue) {
    String regEx = "(\\d*\\.*\\d*)\\^\\(*(\\d*\\.*\\d*)\\)*";
    Pattern pattern = Pattern.compile(regEx);
    Matcher m = pattern.matcher(pValue);
    if (m.find()) {
        String value = "Math.pow(" + m.group(1) + "," + m.group(2) + ")";
        pValue = pValue.replaceAll(regEx, value);
    }
    return pValue;
}