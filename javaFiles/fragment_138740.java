String str3 = "(cmd: (((char))) (ddt)) ()";
    String regexp = "\\(cmd: "+ nestingPair(5, '(', ')')+ "\\)";
    Pattern pMod = Pattern.compile(regexp);
    Matcher mMod = pMod.matcher(str3);
    while (mMod.find()) {
        System.out.println(mMod.group(0));
    }

public String nestingPair(int level, char b, char e) {
    String ret = "";
    if (level <= 0) { return ret; }

    String common = "(?>[^" + b + e + "]*(?>\\\\" + b + "888_888" + "\\\\" + e + ")*[^" + b + e
            + "]*)*";
    String core = "[^" + b + e + "]*";
    String replace = "(?>[^" + b + e + "]*(?>\\" + b + "888_888" + "\\" + e + ")*[^" + b + e
            + "]*)*";
    for (int i = 0; i < level - 1; i++) {
        // System.out.println(replace);
        replace = replace.replaceFirst("888_888", common);
    }
    // System.out.println(replace);
    ret = replace.replaceAll("888_888", core);

    return ret;
}