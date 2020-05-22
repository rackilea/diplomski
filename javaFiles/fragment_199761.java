int count[] = new int[10];
for(int i = 0 ; i < x.length ; i++){
     if( x[i] == 0 ){
         count[0]++;
         continue;
     }
     while(x[i]!=0){
         int index = x[i] % 10;
         count[index]++;
         x[i] /= 10;
     }
}