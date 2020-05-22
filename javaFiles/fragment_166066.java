static void nextGen(int visualize[][], int x, int y) {
        int[][] life = new int[x][y];
        int alive = 0;

        System.out.println();
        System.out.println();
        System.out.println("________");
        System.out.print("_");

        for (int k = 1; k <= 6; k++) {
            for (int l = 1; l <= 6; l++) {
                alive = 0;
                //BEGIN CHECK FOR SURROUNDING LIVES
                if (!(visualize[k + 1][l] == 0)) {
                    if (visualize[k + 1][l] == 2) //Right 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k][l + 1] == 0)) {
                    if (visualize[k][l + 1] == 2) //Up 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k + 1][l + 1] == 0)) {
                    if (visualize[k + 1][l + 1] == 2) // Right 1, Up 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k - 1][l] == 0)) {
                    if (visualize[k - 1][l] == 2) //Left 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k][l - 1] == 0)) {
                    if (visualize[k][l - 1] == 2) // Down 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k - 1][l - 1] == 0)) {
                    if (visualize[k - 1][l - 1] == 2) //Left 1, Down 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k + 1][l - 1] == 0)) {
                    if (visualize[k + 1][l - 1] == 2) //Right 1, Down 1
                    {
                        alive++;
                    }
                }
                if (!(visualize[k - 1][l + 1] == 0)) {
                    if (visualize[k - 1][l + 1] == 2) //Left 1, Up 1
                    {
                        alive++;
                    }
                }

                if (visualize[k][l] == 2 && (alive == 2 || alive == 3)) {
                    life[k][l] = 2;
                }
                else if (visualize[k][l] == 1 && alive == 3) {
                    life[k][l] = 2;
                }
                else {
                    life[k][l] = 1;
                }

                if (life[k][l] == 2) {
                    System.out.print("*");
                }
                else if (life[k][l] == 1) {
                    System.out.print(".");
                }
            }

            System.out.println("_");
            System.out.print("_");
        }
        System.out.println("_______");

        // Copy the 'life' array back to 'visualize', so that the
        // next generation could be calculated from it.
        for (int i = 1; i < 6; ++i)
        {
            visualize[i] = life[i];
        }
    }