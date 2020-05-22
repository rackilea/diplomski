private static String prepare(String input) {
        if (input.length() == 2) {
            return ","+input;
        } 
        if (input.length() == 1) {
            return ",0"+input;
        }
        String integerPart = input.substring(0, input.length()-2);
        String fraction = input.substring(input.length()-2);
        return integerPart+","+fraction;
    }