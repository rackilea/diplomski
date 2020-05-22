public class Main {

public static void main(String args[]) {
    //Returns fourth prime number
    System.out.println(getPrimeNumber(4));


}

public static int getPrimeNumber(int order) {

    int currentOrder = 1;
    int currentNumber = 1;

    while (currentOrder < order) {
        currentNumber++;
        if (isPrime(currentNumber)) currentOrder++;
    }

    return currentNumber;

}


public static boolean isPrime(int number) {
    for (int i = 2; i < number; i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}