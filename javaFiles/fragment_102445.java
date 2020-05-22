public class BitDemo {

    public static void main(String[] args) {
        int encoded = encode(20, 255, 10);
        int[] decoded = decode(encoded);

        System.out.println(Arrays.toString(decoded));
    }

    private static int[] decode(int encoded) {
        return new int[] {
                encoded & 0xFF,
                (encoded >> 8) & 0xFF,
                (encoded >> 16) & 0xFF
        };
    }

    private static int encode(int b1, int b2, int b3) {
        return (b1 & 0xFF) | ((b2 & 0xFF) << 8) | ((b3 & 0xFF) << 16);
    }
}