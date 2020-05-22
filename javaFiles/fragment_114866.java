public static void main(final String[] args) {
    System.out.print("Enter a number: ");
    final Scanner key = new Scanner(System.in);
    final int in = key.nextInt();

    if (isPrime(in)) {
        System.out.println(in + " is a prime number");
    } else {
        System.out.println(in + " is not a prime number");
    }
}

private static boolean isPrime(final int in) {
    if (in < 2) return false;

    for (int i=2; i <= Math.sqrt(in); i++){
        if (in%i == 0){
            return false;
        }
    }
    return true;
}