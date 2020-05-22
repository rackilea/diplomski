public static String abbreviateNumber(long marketCap) {
    int len = String.valueOf(marketCap).length();
    return len > 9 ? String.format("%.2f", marketCap/Math.pow(10, 9))+"B" :
           len > 6 ? String.format("%.2f", marketCap/Math.pow(10, 6))+"M" :
           len > 3 ? String.format("%.2f", marketCap/Math.pow(10, 3))+"K" :
           String.valueOf(marketCap);
}