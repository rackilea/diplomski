char[][] seatsLeft = new char[rows][3];
char[][] seatsRight = new char[rows][3];
for(int i=0i<rows;i++){
    for(int j=0;j<3;j++){
        seatsLeft[i][j]='-';
        seatsRight[i][j]='-';
    }
}