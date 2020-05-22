public class L2BFloat {

    public static void main(String[] argv) {
        int x = 0x66668A42;
        System.out.println(little2Big2Float(x));
    }

    public static float little2Big2Float(int little) {
        // int endian conversion
        int big = (little & 0x000000FF) << 24
                | (little & 0x0000FF00) << 8
                | (little & 0x00FF0000) >>> 8
                | (little & 0xFF000000) >>> 24;
        // convert to float
        return Float.intBitsToFloat(big);
    }

}