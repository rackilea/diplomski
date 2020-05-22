public class GuessMain {
    public static void main(String[] args) {
        GuessLogic guessLogic = new GuessLogic();
        int tries = 1;
        while (!guessLogic.guess()) {
            tries++;
        }
        System.out.println("You Win!");
        System.out.println("It took you " + tries + " tries");
    }
}