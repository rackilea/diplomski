int n = 32;
    for (int i = 1; i <= n; i *= 2) {
        for (int j = i; j < n; j *= 2)
            System.out.print("\t");
        for (int k = i; k >= 1; k /= 2)
            if (i == k)
                System.out.print(k);
            else
                System.out.print("\t" + k);
        System.out.println();
    }