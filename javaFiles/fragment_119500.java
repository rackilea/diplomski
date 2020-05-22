public class Test {
    public static String reverse(String a) {
        int j = a.length();
        char[] newWord = new char[j];
        for (int i = 0; i < a.length(); i++) {
            newWord[--j] = a.charAt(i);
        }
        return new String(newWord);
    }

    public static void main(String a[]) {

        String word = "abcdefgh";
        System.out.println(reverse(word));
    }
}