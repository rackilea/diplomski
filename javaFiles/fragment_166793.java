public class Fizzy {

    //a class *variable*, not a class
    private static int counter;

    //checking if a multiple of 3
    private static boolean isFizz(int i) {
        return i % 3 == 0; //no need for if
    }

    //checking if a multiple of 5
    private static boolean isBuzz(int i) {
        return i % 5 == 0; //no need for if
    }

    public static void main(String[] args) {
        for (counter = 1; counter <= 100; ++counter) {
            if (isFizz(counter) && isBuzz(counter)) { //reuse the methods
                System.out.println("FizzBuzz");
            } else if (isFizz(counter)) { //no need for "== true"
                System.out.println("Fizz");
            } else if (isBuzz(counter)) { //no need for "== true"
                System.out.println("Buzz");
            } else {
                System.out.println(counter);
            }
        }
    }
}