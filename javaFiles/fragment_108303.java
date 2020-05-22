/**
* Round to certain number of decimals
* 
* @param d
* @param decimalPlace
* @return
*/
public static float round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
}