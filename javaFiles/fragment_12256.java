for (int n = 0; n < threadNo; n++)  { //each n relates to a thread
    pool.execute(new Runnable() {
        public void run() {
            for (int row = n; row < height; row += threadNo) { //proceed to the next row for the thread
                for (int col = 1; col < width-1; col++) {
                    avg[col][row] = (img[col - 1][row] + img[col][row] + img[col + 1][row]) / 3;
                   }
                }
            };
        });
    }