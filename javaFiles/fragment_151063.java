public static double squareRootDiv(String number, int decimals){
        if (decimals <= 0) return -1;

        String ans = "";

        int iPart = Integer.parseInt(number.split("\\.")[0]);

        int first = getNext(iPart);
        int remainder = iPart - first*first;
        ans += first;
        int decimalIx = ans.length();
        int numDecimalsNeeded = decimals - ans.length();

        for (int i = 0; i <= numDecimalsNeeded; i++) {

            remainder *= 100;
            int base = Integer.parseInt(ans) * 20;

            for (int j = 9; j >= 0; j--) {

                int trial = (base + j) * j;

                if (trial < remainder) {
                    remainder -= trial;
                    ans += j;
                    break;
                }
            }
        }



        return Double.parseDouble(ans.substring(0, decimalIx) + "." + ans.substring(decimalIx));
    }

    public static int getNext (int iPart) {
        for (int i = 0; i <= iPart; i++) {
            if (i*i > iPart) {
                return i - 1;
            }
        }
        return -1;
    }