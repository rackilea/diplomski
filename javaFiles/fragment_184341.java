public static void fillRight (int [][] fillRightArray, int step){
    int count = 0;
    for (int i = 0; i< fillRightArray.length; i++){
       for (int j = 0; j< fillRightArray[i].length; j++){
           count++;
           fillRightArray[i][j] += step*count;
           System.out.print(fillRightArray[i][j] + " ");
       }
       System.out.print("\n");
    }
}