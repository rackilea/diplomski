public class Test {
    public static void main(String[] args) {
        System.out.println(yourHomework(51,1));
        System.out.println(yourHomework(173,2));
    }
    public static int yourHomework(int number, int index) { // LOL!! Joke!
            for (int i = index + 1; i < 32; i++) {
                if ((number | (1 << i)) == number)
                     return 1 << i;
            }
            return 0; // Or the value it must return if there is not answer
    }
}