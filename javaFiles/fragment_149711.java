public class PalindromeExample {
    /**
     * Returns the number whose digits (base 10) are the reverse
     * of number's (with no leading zeros).
     * @param number the number to reverse
     * @return the reversed number
     */
    public static int reverse( int number ) { 
        int result = 0;
        while ( number > 0 ) {
            result = result * 10 + (number % 10);
            number = number / 10;
        }
        return result;
    }

    /**
     * Show the numbers less than 10000 whose digit sequences
     * are palindromes.
     */
    public static void main(String[] args) {
        for ( int i = 0; i < 10000; i++ ) {
            if ( i == reverse( i ) ) {
                System.out.println( i );
            }
        }
    }
}