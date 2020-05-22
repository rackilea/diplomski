private void recursion(int row, int col, char c) {
    if(array[row][col]==c){
        System.out.print("Location: " + row + " " + col );
    } else {
        if(col+1<array[0].length){
            recursion(row,col+1,c);
        } else if(row + 1<array[1].length){
            recursion(row+1,0,c);
        } else {
            System.out.print("Does not exist");
            //System.out.print(arry[0][1]); 
        }
    }
}