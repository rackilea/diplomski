for (int i=0; i<4; i++) { // our example has 4 doors instead of 64
        // first iteration of outer loop, i = 0
        for (int j=i; j<4; j=j+i+1) {
            // as i = 0, j = 0 too
            // and j = j+i+1 = j + 0 + 1 = j +1 
            // so j will increment by 1
            // hence, j < 4 means the loop will rotate 4 (j = 0 to 3) times 
            doors[j] = !doors[j]; // this line do the trick, See bellow for details.
        }
    }