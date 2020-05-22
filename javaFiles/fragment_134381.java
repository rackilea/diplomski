int counter = 32;   //or 64
for(int i = 0; i < blastTable.length; i++) {
    for(int j = 0; j < blastTable[i].length; j++) {
        blastTable[i][j] = counter;
        counter--;
        System.out.println( blastTable[i][j]);
    }            
}