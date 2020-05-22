public static String inch(double theInch){
    if(theInch == 9999){
        return "----";
    }
    return Double.toString(theInch/25.4);
}