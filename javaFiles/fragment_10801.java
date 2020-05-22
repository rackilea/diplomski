char[][] test = {{'A','B','C'}, {'D','E','F'}, {'G','H','I'}};

int sideLength=115;

for (int i = 0; i < test.length; i++) {
    int x = 90 + sideLength * i;
    for (int j = 0; j < test[j].length; j++) {
        int y = 30 + sideLength * j;

        g.drawRect(x, y, sideLength, sideLength);
        g.drawString(
            Character.toString(test[i][j]), 
            x + sideLength / 2, 
            y + sideLength / 2);

    }  
}