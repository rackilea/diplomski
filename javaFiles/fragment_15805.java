public String check4Triples() {
    int max = number;
    String ret = "";

    for (int a = 1; a <= max; a++) {
        for (int b = a + 1; b <= max; b++) {
            for (int c = b + 1; c <= max; c++) {
                if (isPythagoreanTriple(a, b, c)) {
                    if (mod2(a, b) || mod2(b, a)) {
                        if (greatestCommonFactor(a, b, c) == 1) {
                            ret += "" + a + " " + b + " " + c + "\n";
                        }
                    }
                }
            }
        }
    }

    return ret;
}