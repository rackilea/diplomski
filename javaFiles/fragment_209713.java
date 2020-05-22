public class ConvertBinary {
    public static String convertBinary(int n) {
        String s = "";
        while (n > 0) {
            s += (n % 2);

            n = n / 2;
        }

        int len = s.length();
        String[] binary = s.split("");
        String[] binaryCopy = new String[s.length()];

        s = "";

        for (int i = 0; i < len; i++) {
            binaryCopy[i] = binary[len - i - 1];
            s += binaryCopy[i];
        }
        return s;

    }

    public static void main(String args[]) {
        int num = 4;
        System.out.println(convertBinary(num));
        System.out.println(Integer.toBinaryString(num));
    }
}