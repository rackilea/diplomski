public String getDecimalFractions(BigDecimal value) {
    String strValue = value.toPlainString();
    int index = strValue.indexOf(".");
    if(index != -1) {
        return strValue.substring(index+1, strValue.length());
    } 
    return "0"; 
}