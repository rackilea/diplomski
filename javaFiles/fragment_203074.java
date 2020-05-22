for (int c = 1; c < lucky.length;c++){
   int d = luckyNum * c;
   if (d < lucky.length){
     lucky[d] = 0;
     continue;
   }
}