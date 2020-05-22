for(int i=0;i<a.length;i++){
        for(int j=0;j<a[i].length;j++){
            if(i==0){
                if(j==0){
                    sum[i][j] = a[i][j]*2 + a[i+1][j] + a[i][j+1];
                }
                else if(j==a[i].length-1){
                    sum[i][j] = a[i][j]*2 + a[i][j-1] + a[i+1][j] ;
                }
                else{
                    sum[i][j] = a[i][j] + a[i][j-1] + a[i+1][j] + a[i][j+1];
                }
            }
            else if(i==a.length-1){
                if(j==0){
                    sum[i][j] = a[i][j]*2 + a[i-1][j] + a[i][j+1];
                }
                else if(j==a[i].length-1){
                    sum[i][j] = a[i][j]*2 + a[i][j-1] + a[i-1][j] ;
                }
                else{
                    sum[i][j] = a[i][j] + a[i][j-1] + a[i-1][j] + a[i][j+1];
                }
            }
            else if(j==0){
                sum[i][j] = a[i][j] + a[i-1][j] + a[i+1][j] + a[i][j+1];
            }
            else if(j==a[i].length-1){
                sum[i][j] = a[i][j] + a[i-1][j] + a[i+1][j] + a[i][j-1];
            }
            else{
                sum[i][j] = a[i][j-1] + a[i-1][j] + a[i+1][j] + a[i][j+1];
            }
        }
    }