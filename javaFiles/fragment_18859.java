// Do more of these in reality, of course...
private static final String[] MESSAGES = { "1", "10", "100", "1,000", "10,000" };

public static final String roundUpToPowerOf10(int x) {
    return MESSAGES[(int) Math.ceil(Math.log10(x))];
}