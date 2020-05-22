public static void main(String[] args) {
    final String pattern1 = "^(.{3})*?(abc)";

    final String content1 = "efabcabcdabcefaabcdfabce"; // two matches

    final String content2 = "abcabcdabcefabc"; // three matches

    Matcher mStart = Pattern.compile(pattern1).matcher(content1);

    while (mStart.find()) {
        System.out.println(mStart.group(mStart.groupCount()));
        System.out.println(mStart.start() + ", " + mStart.end());

        mStart = mStart.region(mStart.end(), mStart.regionEnd());
    }

    //-----------------------------
    System.out.println("------------------------");

    mStart = Pattern.compile(pattern1).matcher(content2);

    while (mStart.find()) {
        System.out.println(mStart.group(mStart.groupCount()));
        System.out.println(mStart.start() + ", " + mStart.end());

        mStart = mStart.region(mStart.end(), mStart.regionEnd());
    }
}