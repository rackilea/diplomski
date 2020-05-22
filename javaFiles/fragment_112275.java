this.blocks = new boolean[z][y][x];
    for (int i = 0; i < z; i++) {
        this.blocks[i] = new boolean[y][x];
        for (int j = 0; j < y; j++) {
            this.blocks[i][j] = new boolean[x];
            for(int k = 0; k < x; k++) {
                this.blocks[i][j][k] = (rand.nextInt(1) == 1);
            }
        }
    }
    System.out.println(Arrays.toString(this.blocks));