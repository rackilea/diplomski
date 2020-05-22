private static int decode(String str) {

    construct();

    int n = str.length();
    int[] count = new int[n];

    count[0] = 1;

    for (int i = 1; i < n; i++) {
        String x = codes.get(Integer.parseInt(str.substring(i, i + 1)));
        if (str.charAt(i) != '0')
            count[i] = count[i - 1];
        if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26 && str.charAt(i - 1) != '0')
            count[i] += (i - 2 >= 0 ?  count[i - 2] : 1);
    }

    return count[n - 1];

}