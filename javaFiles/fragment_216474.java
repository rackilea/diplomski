public static String replaceCharsStar(String org, char swapA, char swapB) {
    return org
            .replace("*", "\\*")
            .replace(swapA, '*')
            .replace(swapB, swapA)
            .replaceAll("(?<!\\\\)\\*", "" + swapB)
            .replace("\\*", "*");

}