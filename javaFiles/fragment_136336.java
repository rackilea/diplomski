long start = System.currentTimeMillis();

    for (int i = 0; i < newWidth; i++) {
        double x = i * scaleX;
        double xdiff = x - (int) x;
        int xf = (int) Math.floor(x);
        int xc = (int) Math.ceil(x);
        for (int j = 0; j < newHeight; j++) {
            double y = j * scaleY;
            double ydiff = y - (int) y;

            int yf = (int) Math.floor(y);
            int yc = (int) Math.ceil(y);

            double out = inputArray[xf][yf] * (1 - xdiff) * (1 - ydiff)
                    + inputArray[xc][yf] * xdiff * (1 - ydiff)
                    + inputArray[xf][yc] * (1 - xdiff) * ydiff
                    + inputArray[xc][yc] * xdiff * ydiff;

            outputArray[i][j] = (int) out;
        }
    }

    long elapsed = System.currentTimeMillis() - start;
    System.out.println("Time used: " + elapsed);