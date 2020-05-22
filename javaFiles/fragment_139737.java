for(int row = 0; row < table.length; row++){
    for(int column = 0; column < table[row].length; column++){
        int r =(int)(Math.random()*(9-1+1))+1;
        table[row][column]=r;
        System.out.println(table[row][column]);
    }
}