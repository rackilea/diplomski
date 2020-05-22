public static void main(String[] args) {
    double input = 0.004;
    DecimalFormat formatter = getDecimalFormat(input); 
    System.out.println(formatter.format(round2Digit(input)));
    input = 0.005;
    formatter = getDecimalFormat(input); 
    System.out.println(formatter.format(round2Digit(input)));
    input = 0.015;
    formatter = getDecimalFormat(input); 
    System.out.println(formatter.format(round2Digit(input)));
}

private static DecimalFormat getDecimalFormat(double input){
    DecimalFormat formatter = (input % 1 == 0) ? new DecimalFormat("##.##"): new DecimalFormat("#0.00"); 
    return formatter;
}

private static double round2Digit(double input){
    double result = input * 100;
    result = Math.round(result);
    result = result / 100;
    return result;
}