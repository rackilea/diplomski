static void iterative(String s){
   char[] norm = s.toCharArray();
   System.out.print("\nIteratively:  ");
   for(int i=norm.length-1; i >= 0; i--){
       System.out.print(norm[i]);
   }