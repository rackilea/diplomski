public static int getDiagonal(final List<List<Integer>> list, final int len) {
        int result = 0;
        // [top half]
        for (int i = len - 1; i > 0; --i) {
            //String temp = "";
            int tmp = 0;
            for (int j = 0, x = i; x <= len - 1; ++j, ++x) {
                final int val = list.get(x).get(j);
                //temp = temp + " " + val;
                tmp += val;
            }
            //System.out.println(temp);
            if (tmp > result)
                result = tmp;
        }
        // [lower half]
        for (int i = 0; i <= len - 1; ++i) {
            //String temp = "";
            int tmp = 0;
            for (int j = 0, y = i; y <= len - 1; ++j, ++y) {
                final int val = list.get(j).get(y);
                //temp = temp + " " + val;
                tmp += val;
            }
            //System.out.println(temp);
            if (tmp > result)
                result = tmp;
        }
        return result;
    }
    public static int getAntiDiagonal(final List<List<Integer>> list, final int len) {
        int result = 0;
        // [top half]
        for (int k = 0; k < len; ++k) {
            int tmp = 0;
            for (int j = 0; j <= k; ++j) {
                int i = k - j;
                int val = list.get(i).get(j);
                //System.out.print(val + " ");
                tmp += val;
            }
            if (tmp > result)
                result = tmp;
            //System.out.println();
        }
        // [lower half]
        for (int k = len - 2; k >= 0; --k) {
            int tmp = 0;
            for (int j = 0; j <= k; ++j) {
                int i = k - j;
                int val = list.get(len - j - 1).get(len - i - 1);
                //System.out.print(val + " ");
                tmp += val;
            }
            if (tmp > result)
                result = tmp;
            //System.out.println();
        }
        return result;
    }