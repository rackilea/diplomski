public int countChar(String str, char chr) {
    int count = 0;
    for (int k = 0; k < str.length(); k++) {
        if (str.charAt(k) == chr)
            count++;
    }
    return count;
}

public String fixBug(String eq) {
    boolean hasBug = eq.contains("*-");
    if (hasBug) {
        String subeq;
        int indbug, indp, indm;
        eq = eq.replace("*-", "@");
        int N = countChar(eq, '@');
        for (int k = N; k > 0; k--) {
            indbug = eq.indexOf('@');
            subeq = eq.substring(0, indbug);
            indp = subeq.lastIndexOf('+');
            indm = subeq.lastIndexOf('-');
            if (indp == -1 && indm == -1) {
                eq = "-" + eq;
            } else if (indp > indm) {
                eq = eq.substring(0, indp) + '-' + eq.substring(indp + 1);
            } else {
                eq = eq.substring(0, indm) + '+' + eq.substring(indm + 1);
            }
        }
        eq = eq.replace("@", "*");
    }
    return eq;
}