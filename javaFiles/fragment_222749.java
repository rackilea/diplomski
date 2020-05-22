public static void triangle(int n) {
    for (int i = 0; i < n; ++i) {
        if (i == n-1) {
            for (int j = 0; j < 2*n-1; ++j)
                if (j % 2 == 0)
                    System.out.printf("%c ", 'A' + 2*n-2-j/2);
                else
                    System.out.printf("* ");
            System.out.println();
            break;
        }

        for (int j = 0; j < 2*n-1; ++j) {
            if (j == n-1+i)
                System.out.printf("%c ", 'A'+i);
            else if (j == n-1-i)
                System.out.printf("%c ", 'A'+3*n-i-3);
            else
                System.out.printf("* ");

        }
        System.out.println();
    }
}