public static boolean validateCode2(String code) {
    int numbers = 0, letters = 0, hyphens = 0;
    for (char c : code.toCharArray()) {
        if (Character.isDigit(c)) numbers++;
        if (Character.isAlphabetic(c)) letters++;
        if (c=='-') hyphens++;
    }

    return numbers>=2 && letters>=2 && hyphens>=1;
}