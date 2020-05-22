public static String getOrdinalFor(int value) {
 int tenRemainder = value % 20;

 switch (tenRemainder) {
 case 1:
    return "st";
 case 2:
    return "nd";
 case 3:
    return "rd";
 default:
    return "th";
 }
}