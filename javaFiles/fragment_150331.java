public class Perms {
    private static String[][] array = new String[][] {
        { "1", "2", "3" },
        { "4", "5", "6" },
        { "7", "8", "9" },
        { "10", "11", "12" }
    };
    private static int combinationLength = 2;
    public static void main(String[] args) {
        // Get combinations of subarrays
        for (int i = 0; i < Math.pow(2, array.length); ++i) {
            int c = 0;
            for (int j = 1; j <= Math.pow(2, array.length); j <<= 1)
                if ((i & j) != 0)
                    ++c;
            if (c == combinationLength) {
                String[][] maskedArray = new String[combinationLength][];
                for (int l = 1, j = 0, k = 0; l <= Math.pow(2, array.length); l <<= 1, ++j)
                    if ((i & l) != 0) {
                        maskedArray[k] = array[j];
                        ++k;
                    }
                // Get combinations of one element per subarray
                int l = 1;
                for (int j = 0; j < maskedArray.length; ++j)
                    l *= maskedArray[j].length;
                for (int j = 0; j < l; ++j) {
                    String s = "";
                    int m = j;
                    for (int k = maskedArray.length-1; k >= 0; --k) {
                        s = maskedArray[k][m % maskedArray[k].length] + "," + s;
                        m /= maskedArray[k].length;
                    }
                    // Spit out a result
                    System.out.println(s.substring(0, s.length()-1));
                }
            }
        }
    }
}