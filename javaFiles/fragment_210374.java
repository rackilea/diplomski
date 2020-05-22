for (int row = 1; row <= n; row ++) {
        for (int col = n; col >= 1; col--) {
            if (col <= row) {
                System.out.print(String.format("%2d ", col * col));
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }