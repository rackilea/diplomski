boolean[][] result = new boolean[gridInt.length][];
for (int i = 0; i < gridInt.length; i++) {
     boolean[] temp = new boolean[gridInt[i].length];
     for (int j = 0; j < gridInt[i].length; j++) 
          temp[j] = gridInt[i][j] == 1;         
     result[i] = temp;
}