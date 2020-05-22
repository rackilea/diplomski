package ooexample;

public class RandomNumberGenerator {

    public RandomNumberGenerator() {

    }

    public int randomNumber(int min, int max) {
        int randomNumber = min + (int) (Math.random() * ((max - min) + 1));
        printSomeNumber(randomNumber);

        return randomNumber;
    }

    private void printSomeNumber(int number) {
        System.out.println(number);
    }
}