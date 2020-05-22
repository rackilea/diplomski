public static void f(int n) {
    int i = 2;
    while(i*i <= n) {
        if (n%i == 0) {
            System.out.println("Factors " + i);
            n = n / i;
        }
        else {
            i++;
        }
    }

    if (n > 1) {
        System.out.println("Factors " + n);
    }
}