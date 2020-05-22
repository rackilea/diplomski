int result = 1;
    int x = 2;
    int y = 3;

    Integer [][] polynomials = new Integer[x][y];
    polynomials[0][0] = 1;
    polynomials[0][1] = 2;
    polynomials[0][2] = 3;
    polynomials[1][0] = 4;
    polynomials[1][1] = 5;
    polynomials[1][2] = 6;

    for(int i = 0; i<x; i++) {
        for(int j = 0; j<y; j++) {
            result *= (1 + polynomials[i][j]);
        }
    }
    System.out.println(result);