for(int i=0; i<n;i++){
       for(j=0;j<m;j++){
           for(k=j;k<m;k++){
               if(a[i][j]>a[i][k]){
                 swap(a[i][j],a[i][k]);
               }
           }
      }