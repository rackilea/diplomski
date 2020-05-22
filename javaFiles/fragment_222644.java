public static void main(String[] args) {
    System.out.println(convertFromDec(123, 2)); //converting to binary
    System.out.println(convertFromDec(123, 8)); //converting to octal
    System.out.println(convertFromDec(123, 16)); //converting to hex
}

public static String convertFromDec(int number, int system) {
    String result = "";
    while(number > 0) {
        String digit = ""; //in case of number systems of "rank" 11 or higher
        switch(number%system) { //we would have letters from A to F as additional digits
            case 10 : digit = "A";
            case 11 : digit = "B";
            case 12 : digit = "C";
            case 13 : digit = "D";
            case 14 : digit = "E";
            case 15 : digit = "F";
            default : digit = number%system + "";
        }
        result += digit;
        number /= system;
    }
    return result;
}