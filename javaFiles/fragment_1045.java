for(int i=0; i<arr.length; i++){
    max=0;
    for(int j=0; j<arr.length; j++){
        if(max<arr[i][j]){
            max=arr[i][j];
            for(int k=0; k<arr.length; k++){    
                if(i==k){
                    temp=arr[i][k];
                    arr[i][k]=arr[i][j];
                    arr[i][j]=temp;
                }
            }
        }
    }
}