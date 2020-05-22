public static String weirdOrNotWeird(int n) {
        String ans = "";
        // if n is odd or n is even & 5 < n < 21 print Weird
        if ((n % 2 == 1) || ((n % 2 == 0) && (n > 5 && n < 21))) {
            ans = "Weird";
            // otherwise print Not Weird
        } else {
            ans = "Not Weird";
        }
        return ans;
    }