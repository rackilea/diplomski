public static int biggestLoser(int a, int b) {
    if (a < 1000 || a >= 10000 || b < 1000 || b >= 10000) {
        return Math.min(a, b);
    } else {
        // both a and b are four digits
        int result = 0 ;
        int multiplier = 1 ;

        for (int digit = 0; digit < 4; digit++) {
            int nextDigit = Math.min(a % 10, b % 10);
            result = result + nextDigit * multiplier  ;
            multiplier = multiplier * 10 ;
            a = a / 10 ;
            b = b / 10 ;
        }

        return result ;
    }
}