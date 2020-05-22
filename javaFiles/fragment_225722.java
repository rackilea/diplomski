public static int countInversions(String a) {
    int res = 0;
    int n = a.length();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a.charAt(i) > a.charAt(j))
                res++;
        }
    }
    return res;
}