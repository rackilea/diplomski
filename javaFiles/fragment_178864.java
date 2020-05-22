class Myclass{
   int x;
   Myclass(int i){
      x = i;
   }
   public static void main (String args[]){
     Myclass y = new Myclass(10);
     System.out.println(y.x);
   }
}