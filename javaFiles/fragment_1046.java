//Iterate through the rows.
for(int i=0; i<arr[0].length; i++){
    max=0;
    int m = 0;
    //find the max of the row.
    for(int j=0; j<arr[i].length; j++){
        if(max<arr[i][j]){
            max=arr[i][j];
            m = j; //Store the column of where the max is.
        }
    }
    //Swap the two numbers
    for(int k=0; k<arr[i].length; k++){    
        if(i==k){
            temp=arr[i][k];
            arr[i][k]=arr[i][m];
            arr[i][m]=temp;
        }
    }
}