public static void baseNegate(int base, int[] inDigits, int[] outDigits) {
        // Compute the complement of the digits
        for (int i = outDigits.length - 1; i >= 0; i--)  
            outDigits[i] = base - (1 + inDigits[i]);

        // Negate the complement by adding +1 to the computed number (collection of digits)
        for (int i = 0; i < outDigits.length; i++) {  
            if (outDigits[i] == base - 1) {
                // Max out digit. Set it to zero and try with the higher order next. 
                outDigits[i] = 0;
            } else {
                // Digit that has room for +1. Finally add the 1 and DONE!
                outDigits[i]++;
                break;
            }
        }
    }