int[][] secondaryArray = new int[array.length][]; // Creates the amount row in array
for (int i = 0; i < array.length; i++) 
{ 
    secondaryArray[i] = new int[array[i].length]; // Creates the columns in array
    for (int j = 0; j < array[i].length; j++) 
        secondaryArray[i][j] = array[i][j];
}