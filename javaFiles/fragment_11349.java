int[][] mymethod(int[][]oldArray, int noOfRows){
 int[][] newArr;
 if(noOfRows > 0){
  //here copy from oldArray to new;
  //sorry this is where I can't remember, you will have
  //to do something to get column size maybe oldArray[0].length()
  // but that may not work if each row has different length.
  newArr = new int[noOfRows][];
  for(int i=0; i < noOfRows; i++){
    for(int j = 0; j < noOfRows; j++){
     newArr[i][j] = oldArray[i][j];
    }
  }
 }
return newArr;
}