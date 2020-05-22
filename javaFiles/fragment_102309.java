public static int DeadRabbits(int n, int x) {
    int Fn;
    if (n < 1) {
        Fn = 0;
    }       
    else if (n == 1) {
        Fn = 1;
    }
    else if (n < x + 1) {
        Fn = DeadRabbits(n - 1, x) + DeadRabbits(n - 2, x);
    }
    else if (n == x + 1) {
        Fn = DeadRabbits(n - 1, x) + DeadRabbits(n - 2, x) - 1;
    }
    else {
        Fn = DeadRabbits(n - 1, x) + DeadRabbits(n - 2, x)
            - DeadRabbits(n - x - 1, x);
    }
    return Fn;
}