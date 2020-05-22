Random r = new Random();
    a = new int[x][y];

    int noZeros = r.nextInt((y*x)/2-x) + x;

    boolean z[][] = new boolean[x][y];


    for (int i = 0; i < noZeros; i++) {
        z[r.nextInt(x)][r.nextInt(y)] = true;
    }

    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            if (!z[i][j]) {
                a[i][j] = r.nextInt(9) + 1;
            }
            System.out.print(a[i][j] + " ");
        }
        System.out.println();
    }



    System.out.println();

    int zeros = 0;
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            if (a[i][j] == 0) {
                zeros++;
            }
        }
    }
    System.out.println(zeros);