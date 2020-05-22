public static void main(String[] args)  {
    count89(500);
    count89(1000);
    count89(1221);
}

public static void count89(int max) {
    int count = 0;
    for (int i=1; i<max; i++) {
        if (endIn89(i)) count++;
    }
    System.out.println("f(" + max + ") = " + count);
}

public static boolean endIn89(int n) {
    while (true) {
        int next = 0;
        int digit = 0;
        while (n >= 1) {
            digit = n % 10;
            next += digit * digit;
            n = n / 10;
        }
        n = next;
        if (n==1) return false;
        if (n==89) return true;
    }
}