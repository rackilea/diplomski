public class Test {
    public static void main(String [] args) {
        String temp = Integer.toString(123);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i);
        }
        for (int i : newGuess) {
            System.out.println(i - '0');
        }
    }
}