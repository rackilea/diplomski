for (int i = 1; i <= 100; i++){
   for (int n = i; n <= 100; n+=i){
       if (al.get(n).isClosed()){
           al.get(n).open();
       } else {
           al.get(n).close();    
       }
   }
}