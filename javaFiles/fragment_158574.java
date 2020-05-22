while( k > p && k< 2*p){
    if(Prime(k)){
        System.out.println("the next bigger prime than "+ p + " is "+ k);
         break;
     }           
    k++; 
}