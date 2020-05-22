public static String scale(double value) {
    return value <  1e3 ? asText(value) :
           value <  1e6 ? asText(value / 1e3) + "K" :
           value <  1e9 ? asText(value / 1e6) + "M" :
           value < 1e12 ? asText(value / 1e9) + "B" : 
                          asText(value / 1e12) + "T";
}

public static String asText(double d) {
     return (long) d == d ? Long.toString((long) d) : Double.toString(d);
}