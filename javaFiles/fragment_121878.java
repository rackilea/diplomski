Object [][] data11 = new Object[columns.length][data1.length / 5];
int column = -1;
for(int j = 0; j<data1.length;j++){
    if(j % 5 == 0) column = column + 1
    data11[j % 5][column] = data1[j];
}