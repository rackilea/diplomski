for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++)
            while (bombs[i][j]) { System.out.print("* "); break; }     //Will execute once if the statement holds
            while (!bombs[i][j]) { System.out.print(". "); break; } // Same here.
        System.out.println();
    }