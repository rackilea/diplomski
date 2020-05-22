public class StringBuffer {
    private final static int MAX_LENGTH = 24;
    private static final int N = 100;
    private static String buffer = "";

    public static void main(String[] args) {
        countToN(false);
        System.out.println();
        countToN(true);
    }

    private static void countToN(boolean reverse) {
        for (int count = 2; count <= N; count = count + 2) {
            emit(" " + count, reverse);
        }
        buffer = "";
    }

    private static void emit(String nextChunk, boolean reverse) {
        if (buffer.length() + nextChunk.length() > MAX_LENGTH) {
            System.out.println(buffer);
            buffer = "";
        }
        if (nextChunk.length() == 2) {
            nextChunk = " 0" + nextChunk.trim();
        }
        buffer = (reverse ? nextChunk + buffer : buffer + nextChunk);
    }
}