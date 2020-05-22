public static boolean isANumber(String s) {
    try {
        BigDecimal d = new BigDecimal(s);
        return true;
    } catch (Exception e) {
        return false;
    }
}

public static boolean isAFloat(String s) {
    //same as number, unless you want is a number to 
    //check if it an integer or not
    try {
        BigDecimal d = new BigDecimal(s);
        return true;
    } catch (Exception e) {
        return false;
    }
}

public static boolean isADate(String s) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    try {
        sdf.parse(s);
        return true;
    } catch (Exception e) {
        return false;
    }
}

public static boolean isAText(String s) {
    //everything could be considered a text
    // unless you want to check that characters are within some ranges
    return true;
}