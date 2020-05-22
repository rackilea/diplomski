int rowLength = map.length;
int columnLength = (rowLength==0)0:map[0].length;

//other code
boolean verify(int x, int y){
   return x < rowLength && y < columnLength;
}

//then you can do something like this
int a = verify(row-1,col)? map[row-1][col]: a; //don't change if the index is outOfBounds