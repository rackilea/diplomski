private static int countPrimeNumbers(List<Integer> list) {
    int count = 0;
    for (int i : list) {
        if (isPrime(i)) {
            count += 1;
        }
    }
    return count;
}

// FYI... logic to find prime number can further be optimised, i will leave it upto you
private static boolean isPrime(int number) {
    for(int i = 2; i < number; i++) {
        if(number % i == 0) {
            return false;
        }
    }
    return true;
}

public static void main(String args[]) {
    Integer[] numbers = {2, 3, 5, 6, 10};
    List<Integer> list = Arrays.asList(numbers);

    int result = countPrimeNumbers(list);

    System.out.println("Number of prime numbers = " + result);
}