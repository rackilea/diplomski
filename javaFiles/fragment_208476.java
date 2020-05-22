static int[] generate(int n) {
    // Numbers 100 and 101 contain duplicates, so lower limit is 102.
    // Upper limit is 987 (inclusive), since 988, 989, and 99x all contain duplicates.
    return new Random().ints(102, 988)
            .filter(Test::isThreeUniqueDigits)
            .limit(n)
            .toArray();
}
private static boolean isThreeUniqueDigits(int i) {
    int d1 = i / 100;
    int d2 = i / 10 % 10;
    int d3 = i % 10;
    return (d1 != d2 && d1 != d3 && d2 != d3);
}