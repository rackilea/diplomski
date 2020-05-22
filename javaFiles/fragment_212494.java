for (int i=0; i<4; i++) { // our example has 4 doors instead of 64
        // 2nd iteration of outer loop, i = 1
        for (int j=i; j<4; j=j+i+1) {
            // as i = 1, j = 1 too
            // and j = j+i+1 = j + 1 + 1 = j + 2 
            // so j will increment by 2
            // hence, j < 4 means the loop will rotate 2 (j = 1 and j = 3) times 
            doors[j] = !doors[j]; 
        }
    }