public class StringSplitter {
    public static void main(String[] args) {
        String str = new String("Welcome to Tutorialspoint.com and again some other random stuff in this string.");
        String[] result = new String[8];

        for (int i = 0; i < result.length; ++i) {
            result[i] = "";
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            result[i % result.length] += chars[i];
        }

        for (int i = 0; i < result.length; ++i) {
            System.out.println(result[i]);
        }
    }
}