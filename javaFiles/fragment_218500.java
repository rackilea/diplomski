public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minPrime = 0;
        int maxPrime = 0;
        System.out.println("Please give a number ");
        int number = scanner.nextInt();
        for (int i = number - 1; i > 2; i--) {
            if (isPrime(i)) {
                minPrime = i;
                break;
            }
        }
        for (int i = number + 1; i < Integer.MAX_VALUE; i++) {
            if (isPrime(i)) {
                maxPrime = i;
                break;
            }
        }
        System.out.println(minPrime);
        System.out.println(maxPrime);
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }