for (int i = 0; i < stock.length; ++i) { // After j loop exists, here i again gets incremented.
        for (int j = 1; j < 7; j++) {
            stock[i].setId(letter + "" + j);
            i++; // This increments the value of i 
        }
        letter++;
    }