int n = scanner.nextInt();
int num = 2;
while (num <= n) {
    int i = 2;
    boolean isPrime = true;
    while (i < num && isPrime) {
        if (num % i == 0) {
            isPrime = false;
        }
        i++;
    }
    if (isPrime) {
        int counter = 0;
        while (n >= num && n % num == 0) {
            counter++;
            n /= num;
        }
        if (counter == 1) {
            System.out.println(num);
        }
        else if (counter > 1) {
            System.out.println(num + " " + counter);
        }
    }
    num++;
}