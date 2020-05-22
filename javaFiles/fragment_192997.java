static final int[] weighting = {10, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
// A fully trimmed ABN must be used.
public static boolean validABN(String abn) {
    if (isNumeric(abn)) {
        if (abn.length() == 11) {
            int checksum = 0;
            for (int i = 0; i < abn.length(); i++) {
                int posValue = Character.digit(abn.charAt(i), 10);
                // subtract 1 from first digit only
                if (i == 0) {
                    posValue--;
                }
                // calculate value with position weighting
                checksum += posValue * weighting[i];
            }
            return checksum % 89 == 0;
        } 
    }
    return false;
}