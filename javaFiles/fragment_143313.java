int [][] a = new int[4][5];
int count = 1;
int sign = 1;
for(int j = 0 ; j < 5 ; j++){
    if(sign==1)
        for(int i = 0 ; i < 4 ; i++){
            a[i][j]=count;
            count++;
        }
    else
        for(int i = 3 ; i >=0 ; i--){
            a[i][j]=count;
            count++;
        }
    sign *= -1;
}