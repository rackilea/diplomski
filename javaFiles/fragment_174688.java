int multiply(int x, int y){
   int result = 0;
   while(x > 0){
      result += y;
      x--;
   }
   return result;
}