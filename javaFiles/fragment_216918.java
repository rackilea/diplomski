String s = "[[0,0,2,0],[0,0,2,0],[0,0,0,0],[0,0,0,0]]";

String myNums[] = s.split("[^0-9]+");
//Split at every non-digit

int my_array[][] = new int[4][4];
for(int i = 0; i < 4; i++) {
    for(int j = 0; j < 4; j++) {
        my_array[i][j] = Integer.parseInt(myNums[i*4 + j + 1]);
        //The 1 accounts for the extra "" at the beginning.
    }
}

//Prints the result
for(int i = 0; i < 4; i++) {
    for(int j = 0; j < 4; j++)
        System.out.print(my_array[i][j]);
    System.out.println();
}