int [][] array = new int[4][3];      
array[0][0] = 1;
array[0][1] = 10;
array[0][2] = 100;
array[1][1] = 99;
array[1][2] = 123;
array[1][0] = 177;
array[2][1] = 999;
array[2][2] = 453;
array[3][0] = 000;
array[3][1] = 1090;
array[3][2] = 1202;

for(int x = 0; x < array.length; x++) {
    for(int y = 0; y < array[x].length; y++) {
        System.out.print(array[x][y]);
    }
    System.out.println();
}