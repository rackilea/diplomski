for(int j=0; j<numL; j++){
 for(int k =j+1; k<numL;k++){
     if(train[j]>train[k]){
             aux = train[j];
             train[j]=train[k];
             train[k]=aux;
             swaps++;
        }
     }
 }