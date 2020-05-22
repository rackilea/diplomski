public static void main(String[] args){
    Object [][] objArray = new Object[10][10];

    for (int i=0;i<10;i++){
        for (int j=0;j<10;j++){
            objArray[i][j]= new Class1(i, j);
        }
    }

}