int i = 0;
while(i < stock.length) {
        for (int j = 1; j < 7; j++) {
            stock[i].setId(letter + "" + j);
            i++; // This increments the value of i 
        }
        letter++;
    }