class one implements two,three{
   public void how(){
      System.out.println("\nHow! i = " + i);
     what();
   }

   public void what(){
      System.out.println("\nWhat! i = " + i);
   }

   public static void main(String args[]){
     one a = new one();
     a.how();
     a.what();
   }
}