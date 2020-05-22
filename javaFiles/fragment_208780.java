try {
    for (j = 0; j < width-2; j++) {
        for (k = 0; k < height-2; k++) {
            for (w = 0; w < 3; w++) {
                for (v = 0; v < 3; v++) {
                    int Sj = j + w;
                    int Sv = k+v;
                    sum += ImageMatrix[Sj][Sv] * Kernel[w][v];
                }
            }


    }