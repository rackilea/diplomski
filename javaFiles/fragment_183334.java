public static int intSubstring(int number, int beginIndex, int endIndex) {
    String numString = Integer.toString(number);
    String example = numString.substring(beginIndex,endIndex)
    int subNum = Integer.parseInt(example);
    return subNum;
}