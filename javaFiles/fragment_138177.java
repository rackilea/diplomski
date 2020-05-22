public String stringSplosion(String str) { // string Say 'Code'
    String join = "", values = "";
    String gotIt = "";

    int n = str.length(); // 4

    String[] result = new String[n];

    for (int i = 0; i < str.length(); i++) {
        values = str.substring(i, i + 1);
        join = join + values;
        result[i] = join;
    }
    System.out.println(Arrays.toString(result));

    for (String s : result) {
        gotIt = gotIt + s;
    }

    return gotIt; // Expected output: CCoCodCode
}