for(int i=0;i<a.length-count;){
        if(a[i]==a[i+1]){
            for(int j=i;j<a.length-count;j++){
               a[j]=a[j+1];
            }
            count++;
        }
        else{
            i++;
        }
 }